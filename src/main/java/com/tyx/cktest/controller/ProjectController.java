package com.tyx.cktest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyx.cktest.common.Result;
import com.tyx.cktest.pojo.Project;
import com.tyx.cktest.pojo.User;
import com.tyx.cktest.service.ProjectService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tyx
 * @since 2020-11-23
 */
@RestController
@RequestMapping("/project")
//@CrossOrigin
@Api("项目模块")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @GetMapping("toList")
    public Result toList(Integer userId){
        Result result=null;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("create_user", userId);
        List list = projectService.list(queryWrapper);
        result=new Result("1",list,"项目列表");
        return result;
    }
    @PostMapping("add")
    public Result add(Project project){
        Result result=null;
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        project.setCreateUser(user.getId());
        projectService.save(project);
        result=new Result("1","项目添加成功");
        return result;
    }
}
