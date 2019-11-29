package com.aust.controller;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.service.impl.ProductService;

import com.aust.vo.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * @Autor zhouNan
 * @Date 2019/10/18 16:22
 * @Description ProductController
 **/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/get/{id}")
    public ModelAndView get(@PathVariable("id") Long id) {
        System.out.println("请求成功");
        Product product = productService.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        modelAndView.addObject("product",product);

        return modelAndView;
    }

    @RequestMapping(value = "/list")
    public Object list() {
        return productService.list();
    }


}
