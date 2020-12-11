package com.tyx.cktest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyx.cktest.common.Result;
import com.tyx.cktest.mapper.UserMapper;
import com.tyx.cktest.pojo.User;
import com.tyx.cktest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tyx
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/user")
@Api("用户模块")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userServiceImpl;
    //这是多态的体现
//    private UserService userService;
    //注册
    @PostMapping("/register")
    @ApiOperation(value = "注册方法",httpMethod = "POST")
    public Result register(User user){
        //调用业务层方法，插入到数据库中，save返回值 true, false就处理异常
        user.setRegtime(new Date());
        Result result=null;
        UserMapper userMapper=(UserMapper) userServiceImpl.getBaseMapper();
        int insert = userMapper.insert(user);
        System.out.println("insert:"+insert);
        if(insert==1){
            result=new Result("1","注册成功");
        }else{
            result=new Result("0","注册失败");
        }
        return result;
    }
    //账号验证重复
    @GetMapping("/find")
    @ApiOperation(value = "账户验重方法",httpMethod = "GET")
    public Result find(String username){
        Result result=null;
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        User user = userServiceImpl.getOne(queryWrapper);
        if(user==null){
            result=new Result("1","账号不存在");
        }else{
            result=new Result("0","账号已存在");
        }
        return result;
    }
}
