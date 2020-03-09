package com.aust.controller;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.service.impl.ProductService;

import com.aust.swaggerController.ResultEntity;
import com.aust.vo.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import javax.annotation.Resource;


/**
 * @Autor zhouNan
 * @Date 2019/10/18 16:22
 * @Description ProductController
 **/
@Api(value = "商品接口", tags = "商品接口")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/get",method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "根据ID 获取商品信息")
    public ResultEntity get(@RequestParam("id") @ApiParam(value = "id",name = "id" ,required = true) Long id) {
        System.out.println("请求成功");
        Product product = productService.get(id);
        return ResultEntity.ofSuccess("请求成功",product);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取商品列表")
    public ResultEntity list() {
        return ResultEntity.ofSuccess("请求成功",productService.list());
    }




   /* @RequestMapping(value = "/get/{id}")
    @ApiOperation(value = "根据ID 获取商品信息")
    public ModelAndView get(@PathVariable("id") Long id) {
        System.out.println("请求成功");
        Product product = productService.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        modelAndView.addObject("product",product);

        return modelAndView;
    }*/
}
