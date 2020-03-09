package com.aust.security.config;

import com.aust.config.AppSocialAuthenticationFilterPostProcessor;
import com.aust.config.MyUserDetailService;
import com.aust.security.authention.OAuth2ClientProperties;
import com.aust.security.authention.SAuthenticationFailHandler;
import com.aust.security.authention.SAuthenticationSuccessHandler;
import com.aust.security.authention.SecurityProperties;
import com.aust.security.social.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证服务器
 */
@Configuration
@EnableAuthorizationServer
public class MyOAuthConfiguration extends AuthorizationServerConfigurerAdapter {
    @Bean
    @ConditionalOnMissingBean(value = AuthenticationSuccessHandler.class)
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SAuthenticationSuccessHandler();
    }
    @Bean
    @ConditionalOnMissingBean(value = AuthenticationFailureHandler.class)
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SAuthenticationFailHandler();
    }

    @Bean
    @ConditionalOnMissingBean(value = SocialAuthenticationFilterPostProcessor.class)
    public SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor() {
        return new AppSocialAuthenticationFilterPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    @Qualifier("jwtTokenStore")
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired(required = false)
    private TokenEnhancer jwtTokenEnhancer;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
                //.accessTokenConverter(jwtAccessTokenConverter);

        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
            TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
            List<TokenEnhancer> enhancers = new ArrayList<>();
            enhancers.add(jwtTokenEnhancer);
            enhancers.add(jwtAccessTokenConverter);
            enhancerChain.setTokenEnhancers(enhancers);

            endpoints
                    .tokenEnhancer(enhancerChain)
                    .accessTokenConverter(jwtAccessTokenConverter);
        }
    }

    /**
     * 决定能给哪些clientId, clientSecret发令牌
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        for (OAuth2ClientProperties config : securityProperties.getOauth2().getClients()) {
            builder.withClient(config.getClientId())
                    .secret(config.getClientSecret())
                    .accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
                    .authorizedGrantTypes("refresh_token", "password")
                    .refreshTokenValiditySeconds(259200)
                    .scopes("all", "read", "write");
        }
    }
}