package com.mty.stadium.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 拦截器
 * @author: mty
 **/
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (response.isCommitted()) {
            // 响应已提交，无法创建会话，直接拦截请求
            return false;
        }

        HttpSession session = request.getSession();
        if(session.getAttribute("userInfo") != null){
            return true;
        }
        // 不符合条件的给出提示信息，并转发到主页面
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/logout").forward(request, response);
        //返回true通过，返回false拦截
        return false;
    }
}
