package com.aust.security.authention;

public class AppProperties {

    private String signinProcessUrlOpenId = SecurityConstants.DEFAULT_SIGNIN_PROCESS_URL_OPENID;

    public String getSigninProcessUrlOpenId() {
        return signinProcessUrlOpenId;
    }

    public void setSigninProcessUrlOpenId(String signinProcessUrlOpenId) {
        this.signinProcessUrlOpenId = signinProcessUrlOpenId;
    }
}
