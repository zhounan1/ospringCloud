package com.aust.config;

import java.util.HashMap;

public class AccessTokenEntity {
    private String access_token;

    private String token_type;

    private String userId;

    private String userName;

    private String userPicture;

    private Double userBalance;

    private String phone;

    private HashMap<String,Object> social;

    public AccessTokenEntity(String access_token, String token_type, String userId, String userName, String userPicture, Double userBalance, String phone, HashMap<String, Object> social) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.userId = userId;
        this.userName = userName;
        this.userPicture = userPicture;
        this.userBalance = userBalance;
        this.phone = phone;
        this.social = social;
    }

    public AccessTokenEntity() {
    }

    @Override
    public String toString() {
        return "AccessTokenEntity{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPicture='" + userPicture + '\'' +
                ", userBalance=" + userBalance +
                ", phone='" + phone + '\'' +
                ", social=" + social +
                '}';
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, Object> getSocial() {
        return social;
    }

    public void setSocial(HashMap<String, Object> social) {
        this.social = social;
    }
}
