package com.activemq.controller;

import com.activemq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-07 12:15
 * @Version: 1.0
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/sendMessage")
    public String sendMessage(String to, String subject, String content){
        System.out.println(to + "--" + subject + "--" +content);
        messageService.sendMessage(to, subject, content);
        return "/ok.jsp";
    }
}
