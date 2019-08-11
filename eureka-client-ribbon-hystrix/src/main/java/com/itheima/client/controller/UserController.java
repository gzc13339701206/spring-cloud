package com.itheima.client.controller;

import com.itheima.client.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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
    @HystrixCommand(fallbackMethod = "fallBackUser")
    public User testUser(){
        return  restTemplate.getForObject("http://eureka-client-provider/user/info",User.class);
    }

    /**
     * 当调用微服务eureka-client-provider失败达到了一定的阈值，那么此时
     * hystrix断路器会打开，就会调用fallback失败方法
     * @return
     */
    public User fallBackUser(){
        return new User(2,"李四",28);
    }
}
