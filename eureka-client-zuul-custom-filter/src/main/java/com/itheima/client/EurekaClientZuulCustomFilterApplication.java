package com.itheima.client;

import com.itheima.client.filter.MyPreZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class EurekaClientZuulCustomFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientZuulCustomFilterApplication.class, args);
    }

    @Bean
    MyPreZuulFilter myPreZuulFilter(){
        return  new MyPreZuulFilter();
    }
}
