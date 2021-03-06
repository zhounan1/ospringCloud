package com.aust.service.impl;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.mapper.ProductMapper;
import com.aust.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 15:40
 * @Description ProductServiceImpl
 **/
/*@Service("ProductService")*/
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    private final  String  product = "product";

    @Override
    public Product get(Long id) {
        Product  p = (Product)redisTemplate.opsForValue().get("product" + id);
        if (p == null) {
            Product p1 = productMapper.get(id);
            redisTemplate.opsForValue().set("product" + id, p1 );
            return  p1;
        }
        return p;
    }

    @Override
    public List<Product> list() {
        return productMapper.list();
    }
}
