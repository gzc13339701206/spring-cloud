package com.itheima.client.controller;

import com.itheima.client.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date: 2019/8/11
 * @Author: itheima
 */
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/testUser")
    public User testUser(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-provider");
        int port = serviceInstance.getPort();
        System.out.println("请求的服务对应的应用端口为====》 " + port);
        return  restTemplate.getForObject("http://eureka-client-provider/user/info",User.class);
    }
}
