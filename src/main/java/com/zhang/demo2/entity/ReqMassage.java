package com.zhang.demo2.entity;

import lombok.Data;

/**
 * @author zhangShaoQuan
 * @createTime 2023/5/5 9:50
 */
@Data
public class ReqMassage {
    /**
     * 消息类型 1.接口请求 2.心跳ping 3.消息。。。
     */
    private int type;

    /**
     * client Id 客户端唯一标识 设备id
     */
    private String clientId;

    /**
     * 请求
     */
    private RequestMassage requestMassage;

    /**
     * 心跳
     */
    private PingMassage pingMassage;

    /**
     * 消息
     */
    private Massage massage;
}
