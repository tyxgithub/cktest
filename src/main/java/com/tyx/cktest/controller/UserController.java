package com.tyx.cktest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyx.cktest.common.Result;
import com.tyx.cktest.mapper.UserMapper;
import com.tyx.cktest.pojo.User;
import com.tyx.cktest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tyx
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/user")
@Api("用户模块")
//@CrossOrigin
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    //这是多态的体现
//    private UserService userService;
    //注册
    @PostMapping("/register")
    @ApiOperation(value = "注册方法", httpMethod = "POST")
    public Result register(User user) {
        //调用业务层方法，插入到数据库中，save返回值 true, false就处理异常
        Result result = null;
        UserMapper userMapper = (UserMapper) userServiceImpl.getBaseMapper();
        int insert = userMapper.insert(user);
//        System.out.println("insert:"+insert);
        if (insert == 1) {
            result = new Result("1", "注册成功");
        } else {
            result = new Result("0", "注册失败");
        }
        return result;
    }

    //账号验证重复
    @GetMapping("/find")
    @ApiOperation(value = "账户验重方法", httpMethod = "GET")
    public Result find(String username) {
        Result result = null;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        User user = userServiceImpl.getOne(queryWrapper);
        if (user == null) {
            result = new Result("1", "账号不存在");
        } else {
            result = new Result("0", "账号已存在");
        }
        return result;
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录方法", httpMethod = "POST")
    public Result login(User user) {
        Result result = null;
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            //将sessionId写回
            String sessionId = (String) SecurityUtils.getSubject().getSession().getId();
            User loginUser = (User) subject.getPrincipal();
            result = new Result("1", loginUser.getId(), sessionId);
        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                result = new Result("0", "用户名错误");
            } else {
                result = new Result("0", "密码错误");
            }
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出方法", httpMethod = "GET")
    public Result logout() {
        Result result = null;
        //从shiro退出
        SecurityUtils.getSubject().logout();
        result = new Result("1", "账号未登陆");
        return result;
    }

    @GetMapping("/unauth")
    @ApiOperation(value = "未授权方法", httpMethod = "GET")
    public Result unauth() {
        Result result = null;
        result = new Result("1", "账号未登陆");
        return result;
    }
}
