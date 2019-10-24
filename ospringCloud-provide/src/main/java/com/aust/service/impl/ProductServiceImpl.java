package com.aust.service.impl;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.mapper.ProductMapper;
import com.aust.vo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 15:40
 * @Description ProductServiceImpl
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public Product get(Long id) {
        return productMapper.get(id);
    }

    @Override
    public List<Product> list() {
        return productMapper.list();
    }
}
