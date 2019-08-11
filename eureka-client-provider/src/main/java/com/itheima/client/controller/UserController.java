package com.itheima.client.controller;

import com.itheima.client.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019/8/9
 * @Author: itheima
 */
@RestController
public class UserController {

    @GetMapping("/user/info")
    public User getUserInfo(){
        String jsonStr="";
        return new User(1,"张三",18);
    }
}
