package com.aust.service.impl;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.vo.Product;

import java.util.List;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 15:38
 * @Description ProductService
 **/
public interface ProductService {
    Product  get(Long id);
    List<Product> list();
}
