package com.itheima.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientConsumerRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
        //LoadBalanced注解加载RestTemplate上面在远程调用服务的时候可以实现负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
