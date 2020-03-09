package com.aust.config;

import com.aust.enity.MyUserDetails;
import com.aust.service.impl.LoginService;
import com.aust.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = loginService.login(username);
        if (userInfo == null) {
            new Throwable("用户不存在");
        }
        String userName = userInfo.getUsername();
        String userPicture = userInfo.getUserPicture();
        return new MyUserDetails(
                userInfo.getId(),
                username,
                userInfo.getPhone(),
                userPicture,
                userInfo.getPassword(),
                false,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
        // 如果从数据库 查询到该用户  返回给security passwordEncoder  自动进行密码校验
      //return  User.withUsername(userInfo.getUsername()).password(userInfo.getPassword()).authorities("p1").build();
    }
}
