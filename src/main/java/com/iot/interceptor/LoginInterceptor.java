//package com.iot.interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //登录检查逻辑
//        HttpSession session = request.getSession();
//        Object loginuser = session.getAttribute("loginUser");
//
//        if (loginuser!=null){
//            return true;
//        }
//        //拦截住了，跳转登录页
//        session.setAttribute("msg","请先登录");
//        response.sendRedirect("/");
//        return false;
//    }
//}
