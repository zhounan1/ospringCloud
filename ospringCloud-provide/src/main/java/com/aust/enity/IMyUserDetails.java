package com.aust.enity;

/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.security.SocialUserDetails;

/**
 * @author: Lujunlei
 * @create: 2019-03-07 13:37
 * @description:
 **/
public interface IMyUserDetails extends UserDetails , SocialUserDetails {

    String getUserId();

    String getUserPicture();

    String getNickName();

    boolean isSocial();

}

