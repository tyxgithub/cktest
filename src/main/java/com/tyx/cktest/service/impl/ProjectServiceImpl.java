package com.tyx.cktest.service.impl;

import com.tyx.cktest.pojo.Project;
import com.tyx.cktest.mapper.ProjectMapper;
import com.tyx.cktest.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tyx
 * @since 2020-11-23
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
