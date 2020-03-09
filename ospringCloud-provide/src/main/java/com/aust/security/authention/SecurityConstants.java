package com.aust.security.authention;

public class SecurityConstants {
    /**
     * 当请求需要身份认证时，默认跳转的url
     */
    public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/dispatch";

    /**
     * 默认获取图像验证码的url
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_IMAGE = "/code/image";

    /**
     * 默认获取短信验证码的url
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_SMS = "/code/sms";

    /**
     * 默认获取短信验证码的url
     */
    public static final String UPDATE_VALIDATE_CODE_URL_SMS = "/code/sms/update";

    /**
     * 注册处理url
     */
    public static final String DEFAULT_SINGUP_PROCESS_URL = "/register";

    /**
     * 阿里支付回调url
     */
    public static final String ORDER_PAY_NOTIFY_URL = "/orderPayNotify";

    /**
     * 默认的用户名密码登录请求处理url
     */
    public static final String DEFAULT_SIGNIN_PROCESS_URL_FORM = "/authentication/form";

    /**
     * 默认的手机验证码登录请求处理url
     */
    public static final String DEFAULT_SIGNIN_PROCESS_URL_MOBILE = "/authentication/mobile";

    /**
     * 默认的openid登陆请求处理url
     */
    public static final String DEFAULT_SIGNIN_PROCESS_URL_OPENID = "/authentication/openId";

    /**
     * app端手机号注册
     */
    public static final String USER_REGISTER_BY_PHONE = "/register/user";

    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    public static final String DEFAULT_REQUEST_PARAMETER_IMAGECODE = "imageCode";

    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    public static final String DEFAULT_REQUEST_PARAMETER_SMSCODE = "smsCode";

    public static final String DEFAULT_REQUEST_PARAMETER_SOCIAL_CODE = "socialCode";

    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    public static final String DEFAULT_REQUEST_PARAMETER_MOBILE = "mobile";

    /**
     * 社交登陆时， 传递的openId参数名
     */
    public static final String DEFAULT_REQUEST_PARAMETER_OPENID = "openId";

    /**
     * 社交登陆时，传递的providerId参数名
     */
    public static final String DEFAULT_REQUEST_PARAMETER_PROVIDER_ID = "providerId";

    /**
     * 默认的Social UserConnection表名的前缀
     */
    public static final String DEFAULT_SOCIAL_USER_CONNECTION_PREFIX = "opera_";

    /**
     * 默认退出登陆URL
     */
    public static final String DEFAULT_SIGNOUT_URL = "/signout";

    /**
     * 默认退出登陆后删除的cookies
     */
    public static final String[] DEFAULT_SIGNOUT_DELETE_COOKIES = new String[]{"JSESSIONID", "SESSIONID"};
}
