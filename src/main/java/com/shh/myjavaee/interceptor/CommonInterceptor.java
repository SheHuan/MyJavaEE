package com.shh.myjavaee.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.err.println("preHandle");
        System.out.println("getServletPath:" + httpServletRequest.getServletPath());
        System.out.println("getContextPath:" + httpServletRequest.getContextPath());
        System.out.println("getRequestURI:" + httpServletRequest.getRequestURI());
        System.out.println("getRequestURL:" + httpServletRequest.getRequestURL());
//        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/fail.jsp").forward(httpServletRequest, httpServletResponse);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.err.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.err.println("afterCompletion");
    }
}
