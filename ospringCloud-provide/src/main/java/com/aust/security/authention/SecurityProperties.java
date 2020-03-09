package com.aust.security.authention;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("globalSecurityProperties")
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private CommonProperties browser = new CommonProperties();

    private OAuth2Properties oauth2 = new OAuth2Properties();

    private SocialProperties social = new SocialProperties();

    private AppProperties app = new AppProperties();

    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }

    public CommonProperties getBrowser() {
        return browser;
    }

    public void setBrowser(CommonProperties browser) {
        this.browser = browser;
    }

    public AppProperties getApp() {
        return app;
    }

    public void setApp(AppProperties app) {
        this.app = app;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }


}
