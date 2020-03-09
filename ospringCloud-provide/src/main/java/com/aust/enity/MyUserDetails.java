package com.aust.enity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author: Lujunlei
 * @create: 2019-03-07 10:37
 * @description: 重新封装了userdetails对象
 **/
public class MyUserDetails extends User implements IMyUserDetails {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userPicture;

    private String nickName;

    private boolean social;

    public MyUserDetails(
            String id, String nickName, String phone, String userPicture,
            String password, boolean isSocial, Collection<? extends GrantedAuthority> authorities) {
        super(phone, password, true, true,
                true, true, authorities);
        this.id = id;
        this.userPicture = userPicture;
        this.nickName = nickName;
        this.social = isSocial;
    }

    @Override
    public String getUserId() {
        return id;
    }

    @Override
    public String getUserPicture() {
        return userPicture;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public boolean isSocial() {
        return social;
    }
}
