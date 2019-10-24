package com.aust.service.impl;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

/**
 * @Autor zhouNan
 * @Date 2019/10/24 10:11
 * @Description Test
 **/
public class Test {

    public static void main(String[] args){

    A a = new A("zhoun");
    change(a);
        System.out.println(a.name);
    }

    public static void change(A a){
        a = new A("change");
    }
    public static class A{
        private String name;
        A(String name){
            this.name = name;
        }
    }
}
