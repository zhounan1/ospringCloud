package com.aust.security.qq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Value("${security.social.qq.app-id}")
    private String qqAppId;

    @Value("${security.social.qq.app-secret}")
    private String qqAppSecret;

    @Value("${security.social.qq.provider-id}")
    private String qqProviderId;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new QQConnectionFactory(qqProviderId, qqAppId, qqAppSecret);
    }
}
