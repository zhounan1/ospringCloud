package com.aust.service.impl;

import com.aust.mapper.LoginMapper;
import com.aust.vo.UserInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Autor zhouNan
 * @Date 2020/02/26 15:44
 * @Description LoginServiceImpl
 **/
@Service("LoginService")
public class LoginServiceImpl implements   LoginService {


    @Resource
    private LoginMapper loginMapper;


    @Override
    //@Cacheable(value = "user")
    public UserInfo login(String userName) {
       UserInfo userInfo =  loginMapper.login(userName);
        return userInfo;
    }
    @Override
    public UserInfo loginId(String userId) {
        UserInfo userInfo =  loginMapper.loginId(userId);
        return userInfo;
    }

    @Override
    public List<UserInfo> getList() {
        List<UserInfo> list = loginMapper.getList();
        return list;
    }
}
