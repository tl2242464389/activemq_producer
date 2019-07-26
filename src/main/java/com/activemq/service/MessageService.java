package com.activemq.service;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-07 12:20
 * @Version: 1.0
 */
public interface MessageService {
    void sendMessage(String to, String subject, String content);
}
