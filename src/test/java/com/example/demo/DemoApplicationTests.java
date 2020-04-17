package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String str="123456";
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }

}
