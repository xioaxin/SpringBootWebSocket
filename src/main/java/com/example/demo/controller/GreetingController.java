package com.example.demo.controller;


import com.example.demo.pojo.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Description:
 * @author: ZPX
 * @createDate: 2020/4/17 22:47
 * @version: 1.0
 */
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }
}




