package com.aust.mapper;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.vo.Product;

import java.util.List;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 15:41
 * @Description ProductMapper
 **/
public interface ProductMapper {
    Product get(Long id);
    List<Product> list();
}
