package com.memos.memosapp.interceptor;

import com.memos.memosapp.utils.JwtUtil;
import com.memos.memosapp.utils.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    // 请求到达 Controller 之前执行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 从请求头拿 Token
        String token = request.getHeader("Authorization");

        // 验证 Token
        if (token == null || !JwtUtil.validate(token)) {
            response.setStatus(401);
            response.getWriter().write("请先登录");
            return false;  // false = 拦截，不往下走
        }

        // Token 有效，把用户ID存入 UserContext
        Long userId = JwtUtil.getUserId(token);
        UserContext.setUserId(userId);
        return true;  // true = 放行
    }

    // 请求完成后执行（清理 ThreadLocal）
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        UserContext.clear();
    }
}