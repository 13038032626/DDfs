package com.example.mydfs_storage.Interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class AccessCounterInterceptor implements HandlerInterceptor {
//
//    private static int totalAccessCount = 0;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 在请求处理之前执行，增加总访问次数
//        totalAccessCount++;
//        return true; // 继续执行后续的拦截器和处理器
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // 在请求处理之后执行，可以在这里进行一些后处理操作
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        // 在整个请求处理完成之后执行，可以进行一些清理工作
//    }
//
//    public static int getTotalAccessCount() {
//        return totalAccessCount;
//    }
//}

