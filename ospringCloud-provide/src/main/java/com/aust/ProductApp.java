package com.aust;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 16:31
 * @Description ProductApp
 **/
@SpringBootApplication
@MapperScan("com.aust.mapper")
public class ProductApp {
    public static void  main(String[] args){
        SpringApplication.run(ProductApp.class);
    }
}
