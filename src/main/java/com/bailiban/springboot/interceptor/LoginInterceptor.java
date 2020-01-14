package com.bailiban.springboot.interceptor;

import com.bailiban.springboot.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不拦截 login
        String url = request.getRequestURI();

        if (url.contains("/login") || url.contains("/register")) {
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 转发
//            request.getRequestDispatcher("/user/login").forward(request, response);
            // 重定向
            response.sendRedirect("/user/login");
            return false;
        }
        return true;
    }
}
