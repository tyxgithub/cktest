package com.tyx.cktest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyx.cktest.common.Result;
import com.tyx.cktest.service.ProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}
