package com.tyx.cktest.service.impl;

import com.tyx.cktest.pojo.User;
import com.tyx.cktest.mapper.UserMapper;
import com.tyx.cktest.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
