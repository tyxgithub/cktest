package com.tyx.cktest.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Author:   tyx
 * Date:     2020/12/11 20:12
 * Description:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("regtime", new Date(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
 
