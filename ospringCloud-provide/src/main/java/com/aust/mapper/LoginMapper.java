package com.aust.mapper;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.aust.vo.Product;
import com.aust.vo.UserInfo;

import java.util.List;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 15:41
 * @Description ProductMapper
 **/
public interface LoginMapper {
    UserInfo login(String userName);
    UserInfo loginId(String userName);
    List<UserInfo> getList();
}
