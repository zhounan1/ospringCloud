package com.aust.controller;


import com.aust.config.AccessTokenEntity;
import com.aust.config.MyUserDetailService;

import com.aust.enity.MyUserDetails;
import com.aust.utils.Message;
import com.aust.utils.MessageUtil;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Api(value = "登陆接口", tags = "测试登陆接口类")
@RestController
@RequestMapping("/authentication")
public class LoginController {


    @Autowired
    @Qualifier("myUserDetailService")
    private MyUserDetailService myUserDetailService;

    @ApiOperation(value = "登入身份验证")
    @PostMapping("/form")
    @ApiImplicitParam(defaultValue = "Basic eGl5dWFuOnhpeXVhbg==",
            name = "Authorization", paramType = "header", required = true)
    public Message login(@RequestParam @ApiParam String username, @RequestParam @ApiParam  String password, HttpServletRequest request) {
        OAuth2AccessToken token = (OAuth2AccessToken) request.getAttribute("accessToken");
        MyUserDetails myUserDetails = (MyUserDetails) request.getAttribute("myUserDetails");
        System.out.println("------------跳转到登陆--"+ token);
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenEntity.setAccess_token(token.getValue());
        accessTokenEntity.setToken_type(token.getTokenType());
        accessTokenEntity.setUserId(myUserDetails.getUserId());
        accessTokenEntity.setUserName(myUserDetails.getUsername());
        return MessageUtil.success(accessTokenEntity);
    }

}
