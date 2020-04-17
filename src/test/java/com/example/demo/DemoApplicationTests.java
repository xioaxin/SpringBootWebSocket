package com.example.demo;


import com.example.demo.pojo.ActiveMQMessage;
import com.example.demo.utils.JmsComponent;
import com.example.demo.utils.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    MailService mailService;

    @Test
    public void contextLoads() {
       mailService.sendAttachFileMail("444047485@qq.com","3442573074@qq.com","你好","你好", new File("D:\\SpringBootWebSocket\\src\\main\\resources\\static\\files\\第3章 模糊逻辑.ppt"));
    }
}
