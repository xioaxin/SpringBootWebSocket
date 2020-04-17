package com.example.demo.controller;


import com.example.demo.pojo.Chat;
import com.example.demo.pojo.Message;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Map;

/**
 * @Description:
 * @author: ZPX
 * @createDate: 2020/4/17 22:47
 * @version: 1.0
 */
@Controller
public class GreetingController {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }

    @MessageMapping("/chat")
    @ResponseBody
    public void chat(Principal principal, Chat chat, Model model) {
        model.addAttribute("username", principal.getName());
        String from = principal.getName(); //获取当前登录的用户名
        System.out.println(principal.getName());
        chat.setFrom(from);
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }
}




