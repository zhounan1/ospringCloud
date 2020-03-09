package com.aust.security.authention;

public class CommonProperties {
    private String signupProcessUrl = SecurityConstants.DEFAULT_SINGUP_PROCESS_URL;

    private String orderPayNotifyUrl = SecurityConstants.ORDER_PAY_NOTIFY_URL;

    private String unAuthenticationUrl = SecurityConstants.DEFAULT_UNAUTHENTICATION_URL;

    private String validateCodeUrlImage = SecurityConstants.DEFAULT_VALIDATE_CODE_URL_IMAGE;

    private String validateCodeUrlSms = SecurityConstants.DEFAULT_VALIDATE_CODE_URL_SMS;

    private String validateCodeUrlSmsForUpdate = SecurityConstants.UPDATE_VALIDATE_CODE_URL_SMS;

    private String signinProcessUrlForm = SecurityConstants.DEFAULT_SIGNIN_PROCESS_URL_FORM;

    private String signinProcessUrlMobile = SecurityConstants.DEFAULT_SIGNIN_PROCESS_URL_MOBILE;

    private String registerUserByPhone = SecurityConstants.USER_REGISTER_BY_PHONE;


    private int rememberMeSeconds = 604800;

    private String signoutUrl = SecurityConstants.DEFAULT_SIGNOUT_URL;

    private String[] signoutDeleteCookies = SecurityConstants.DEFAULT_SIGNOUT_DELETE_COOKIES;

    public String getOrderPayNotifyUrl() {
        return orderPayNotifyUrl;
    }

    public CommonProperties setOrderPayNotifyUrl(String orderPayNotifyUrl) {
        this.orderPayNotifyUrl = orderPayNotifyUrl;
        return this;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getUnAuthenticationUrl() {
        return unAuthenticationUrl;
    }

    public void setUnAuthenticationUrl(String unAuthenticationUrl) {
        this.unAuthenticationUrl = unAuthenticationUrl;
    }

    public String getSigninProcessUrlForm() {
        return signinProcessUrlForm;
    }

    public void setSigninProcessUrlForm(String signinProcessUrlForm) {
        this.signinProcessUrlForm = signinProcessUrlForm;
    }

    public String getSigninProcessUrlMobile() {
        return signinProcessUrlMobile;
    }

    public void setSigninProcessUrlMobile(String signinProcessUrlMobile) {
        this.signinProcessUrlMobile = signinProcessUrlMobile;
    }

    public String getValidateCodeUrlImage() {
        return validateCodeUrlImage;
    }

    public void setValidateCodeUrlImage(String validateCodeUrlImage) {
        this.validateCodeUrlImage = validateCodeUrlImage;
    }

    public String getValidateCodeUrlSms() {
        return validateCodeUrlSms;
    }

    public void setValidateCodeUrlSms(String validateCodeUrlSms) {
        this.validateCodeUrlSms = validateCodeUrlSms;
    }

    public String getSignupProcessUrl() {
        return signupProcessUrl;
    }

    public void setSignupProcessUrl(String signupProcessUrl) {
        this.signupProcessUrl = signupProcessUrl;
    }

    public String getSignoutUrl() {
        return signoutUrl;
    }

    public void setSignoutUrl(String signoutUrl) {
        this.signoutUrl = signoutUrl;
    }

    public String[] getSignoutDeleteCookies() {
        return signoutDeleteCookies;
    }

    public void setSignoutDeleteCookies(String[] signoutDeleteCookies) {
        this.signoutDeleteCookies = signoutDeleteCookies;
    }

    public String getRegisterUserByPhone() {
        return registerUserByPhone;
    }

    public void setRegisterUserByPhone(String registerUserByPhone) {
        this.registerUserByPhone = registerUserByPhone;
    }

    public String getValidateCodeUrlSmsForUpdate() {
        return validateCodeUrlSmsForUpdate;
    }

    public void setValidateCodeUrlSmsForUpdate(String validateCodeUrlSmsForUpdate) {
        this.validateCodeUrlSmsForUpdate = validateCodeUrlSmsForUpdate;
    }
}
