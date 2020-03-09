package com.aust;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 16:31
 * @Description ProductApp
 **/
@SpringBootApplication
@MapperScan("com.aust.mapper")
@EnableScheduling
public class ProductApp {
    public static void  main(String[] args){
        SpringApplication.run(ProductApp.class);
    }


    private static final SimpleDateFormat dateFormat =  new SimpleDateFormat("HH:mm:ss");

  /*  @Scheduled(fixedDelayString = "5000")
    public void getTask1 () {
        System.out.println("任务1 : 当前时间" + dateFormat.format(new Date()));

    }

    @Scheduled(cron = "0/5 * * 　* * ?")
    public void getTask2 () {
        System.out.println("任务２ : 当前时间" + dateFormat.format(new Date()));

    }*/
}
