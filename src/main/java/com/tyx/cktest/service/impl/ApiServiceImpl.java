package com.tyx.cktest.service.impl;

import com.tyx.cktest.pojo.Api;
import com.tyx.cktest.mapper.ApiMapper;
import com.tyx.cktest.service.ApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tyx
 * @since 2020-11-23
 */
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {

}
