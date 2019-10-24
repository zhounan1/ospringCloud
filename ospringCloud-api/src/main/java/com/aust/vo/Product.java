package com.aust.vo;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

/**
 * @Autor zhouNan
 * @Date 2019/10/18 15:31
 * @Description Product
 **/
public class Product {
    private String productId;
    private String productName;
    private String productDesc;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public Product setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public Product setProductDesc(String productDesc) {
        this.productDesc = productDesc;
        return this;
    }
}
