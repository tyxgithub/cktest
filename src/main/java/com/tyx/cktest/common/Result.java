package com.tyx.cktest.common;

import lombok.Data;

/**
 * @program: cktest
 * @description:
 * @author: tyx
 * @create: 2020-11-23 21:10
 **/
@Data
public class Result {
    private String status;
    private Object data;
    private String message;

    public Result(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Result(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
