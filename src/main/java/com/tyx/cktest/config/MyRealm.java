package com.tyx.cktest.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyx.cktest.pojo.User;
import com.tyx.cktest.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author:   tyx
 * Date:     2020/12/11 20:42
 * Description:
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //身份授权（权限管理）
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //认证逻辑
        String username= token.getPrincipal().toString();
        String password = token.getCredentials().toString();
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        User dbUser = userService.getOne(queryWrapper);
        if(dbUser!=null){
//            if(dbUser.getPassword().equals(password)){
//            }
            return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),getName());
        }
        return null;
    }
}
 
