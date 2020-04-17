package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description: WebSecurity的配置
 * @author: ZPX
 * @createDate: 2020/4/18 0:21
 * @version: 1.0
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("a")
                .password("$2a$10$ZDBer5ECIkRIQzFi0ywupOPuHw8yyk0sGt48O4xHEAl0HuhoNIe9m")
                .roles("admin")
                .and()
                .withUser("b")
                .password("$2a$10$ZDBer5ECIkRIQzFi0ywupOPuHw8yyk0sGt48O4xHEAl0HuhoNIe9m")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }
}




