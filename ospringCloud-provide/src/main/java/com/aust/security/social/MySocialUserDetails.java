package com.aust.security.social;

import com.aust.enity.MyUserDetails;
import com.aust.service.impl.LoginService;
import com.aust.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class MySocialUserDetails implements SocialUserDetailsService {

    @Autowired
    LoginService loginService;

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        UserInfo userInfo = loginService.loginId(userId);

        String username = userInfo.getUsername();
        String userPicture = "/user/touxiang.jpg";
        return new MyUserDetails(
                userInfo.getId(),
                username,
                userInfo.getPhone(),
                userPicture,
                userInfo.getPassword(),
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    }


}
