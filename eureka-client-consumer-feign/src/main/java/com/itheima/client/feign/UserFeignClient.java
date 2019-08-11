package com.itheima.client.feign;

import com.itheima.client.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Date: 2019/8/11
 * @Author: itheima
 */
@FeignClient(name="eureka-client-provider")
public interface UserFeignClient {

    @GetMapping("/user/info")
    public User getFeignUser();
}
