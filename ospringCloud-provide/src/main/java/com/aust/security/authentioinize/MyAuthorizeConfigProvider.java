package com.aust.security.authentioinize;

import com.aust.security.authention.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class MyAuthorizeConfigProvider implements AuthorizeConfigProvider {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(
                securityProperties.getBrowser().getSignupProcessUrl(),
                securityProperties.getBrowser().getUnAuthenticationUrl(),
                securityProperties.getBrowser().getSigninProcessUrlMobile(),
                securityProperties.getBrowser().getValidateCodeUrlImage(),
                securityProperties.getBrowser().getValidateCodeUrlSms(),
                securityProperties.getBrowser().getValidateCodeUrlSmsForUpdate(),
                securityProperties.getBrowser().getRegisterUserByPhone(),
                securityProperties.getBrowser().getOrderPayNotifyUrl(),
                "/sms/social/band",
                "/social/check/sms/band",
                "/social/check",
                "/social/sms/band",
                "/forget/user/pwd",
                "/sms/forget",
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources",
                "/configuration/security",
                "/swagger-ui.html", "/webjars/**",
                "/swagger-resources/configuration/ui",
                "/swagge‌​r-ui.html",
                "/userfiles/1/images/**",
                "/userfiles/1/files/**",
                "/userfiles/**",
                "/data/minio/xiyuan-systemdata/userfiles/1/images/",
                "/data/minio/xiyuan-systemdata/userfiles/1/files/",
                "/data/minio/xiyuan-systemdata/userfiles/",
                "/static/index.html",
                "/index.html",
                "/login/*",
                "/auth/*",
                "/product/*",
                "/social/signup/*"
        ).permitAll();
    }

}
