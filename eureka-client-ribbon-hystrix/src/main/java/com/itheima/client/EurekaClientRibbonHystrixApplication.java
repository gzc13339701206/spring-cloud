package com.itheima.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker // 当前应用配置该注解，hystrix就可以在该工程发挥断路器作用
public class EurekaClientRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientRibbonHystrixApplication.class, args);
    }
    @Bean
    @LoadBalanced
        //LoadBalanced注解加载RestTemplate上面在远程调用服务的时候可以实现负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
