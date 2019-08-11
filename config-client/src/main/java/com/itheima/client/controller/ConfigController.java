package com.itheima.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019/8/11
 * @Author: itheima
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${profile}")
    private String myProfile;

    @GetMapping("/testConfig")
    public String getConfigContent(){
        return myProfile;
    }

}
