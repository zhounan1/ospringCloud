package com.aust.vo;/*
 * Copyright © 2016 睿泰集团 版权所有
 */


import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Autor zhouNan
 * @Date 2019/10/18 15:31
 * @Description Product
 **/
public class UserInfo implements Serializable {
    private String id;
    private String username;
    private String password;
    private String phone;
    private String address;
    private LocalDate birthday;
    private String userPicture;
    private boolean locked;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", userPicture='" + userPicture + '\'' +
                ", locked=" + locked +
                '}';
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public UserInfo() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public UserInfo(String id, String username, String password, String phone, String address, LocalDate birthday, String userPicture, boolean locked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.userPicture = userPicture;
        this.locked = locked;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }
}
