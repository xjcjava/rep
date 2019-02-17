package cn.it.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截访问
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (handler instanceof DefaultServletHttpRequestHandler || session.getAttribute("user")!=null){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return false;
    }
}
