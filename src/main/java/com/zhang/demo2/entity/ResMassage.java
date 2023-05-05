package com.zhang.demo2.entity;

import lombok.Data;

/**
 * @author zhangShaoQuan
 * @createTime 2023/5/5 10:01
 */
@Data
public class ResMassage {
    /**
     * 消息类型 1.接口响应 2.心跳pong 3.消息。。。
     */
    private int type;

    /**
     * 响应内容
     */
    private ResponseMassage responseMassage;

    /**
     * pong
     */
    private PingMassage pingMassage;

    /**
     * 消息
     */
    private Massage massage;
}
