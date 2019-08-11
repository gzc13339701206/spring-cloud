package com.itheima.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Date: 2019/8/9
 * @Author: itheima
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
}
