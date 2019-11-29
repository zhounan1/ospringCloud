package com.aust.controller;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor zhouNan
 * @Date 2019/11/12 14:11
 * @Description ConsumerContrller
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @RequestMapping( value = "/get/{id}")
    public Object get(@PathVariable Long  id) {
        System.out.println("请求成功");
        return id;
    }
}
