package com.zhang.demo2.entity;

import lombok.Data;

/**
 * @author zhangShaoQuan
 * @createTime 2023/5/5 9:53
 */
@Data
public class RequestMassage {
    private String uuid;
    private String method;
    private String url;
    private Object header;
    private Object body;
}
