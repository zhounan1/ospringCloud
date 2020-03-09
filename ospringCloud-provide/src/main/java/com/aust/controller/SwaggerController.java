package com.aust.controller;


import com.aust.utils.Message;
import com.aust.utils.MessageUtil;



import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;



@RestController
@RequestMapping("/authentication")
public class SwaggerController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 当需要身份认证时，跳转到这里
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/dispatch")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Message requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                // TODO 跳转到登陆页面
                redirectStrategy.sendRedirect(request, response, "/login.html");
            }
        }
        return MessageUtil.error(401,"访问的服务需要身份认证，请引导用户到登录页");
    }


}
