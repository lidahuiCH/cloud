package com.spring.handler.handler;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor extends HandlerInterceptorAdapter {
    private static final String username = "wang";
    private static final String pwd = "123";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle start...");
        String usernameParam = request.getParameter("username");
        String pwdParam = request.getParameter("pwd");
        if (!StringUtils.isEmpty(usernameParam) && !StringUtils.isEmpty(pwdParam)) {
            if (username.equals(usernameParam) && pwdParam.equals(pwd)) {
                System.out.println("TRUE");
                return Boolean.TRUE;
            } else {
                System.out.println("FALSE");
                response.sendRedirect(request.getContextPath() + "/index/errorIndex");
                return Boolean.FALSE;
            }
        } else {
            return Boolean.TRUE;
        }
    }
}
