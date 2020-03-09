package com.aust.security.config;


import com.aust.security.authentioinize.AuthorizeConfigManager;
import com.aust.security.authention.SecurityProperties;
import com.aust.security.openId.OpenIdAuthenticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    SpringSocialConfigurer mySpringSocialConfigurer;



    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                //qq登陆
                .apply(mySpringSocialConfigurer)
                .and()
                // 第三方登陆
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                // 表单登陆相关配置
                .formLogin()
                .loginPage(securityProperties.getBrowser().getUnAuthenticationUrl()) //表单登陆URL
                .loginProcessingUrl(securityProperties.getBrowser().getSigninProcessUrlForm()) //处理登陆请求的URL
                .successHandler(authenticationSuccessHandler) // 登陆成功处理器
                .failureHandler(authenticationFailureHandler) // 登陆失败处理器
                .and()
                .csrf()
                .disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }
}
