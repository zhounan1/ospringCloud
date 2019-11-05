package com.aust.service.impl;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.mapper.ProductMapper;
import com.aust.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Autor zhouNan
 * @Date 2019/11/5 15:44
 * @Description ProductServiceImpl1
 **/
@Service("ProductService")
public class ProductServiceImpl1 extends  ProductServiceImpl implements  ProductService {
    @Resource
    private ProductMapper productMapper;


    @Cacheable(value = "product")
    public Product get(Long id) {
        System.out.println("走的spirngCache");
        return productMapper.get(id);
    }

    @Override
    public List<Product> list() {
        return productMapper.list();
    }

}
