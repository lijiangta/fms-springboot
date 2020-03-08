package com.dxs.fms.interceptor;

import com.dxs.fms.pojo.UserPojo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author dxs
 * @date 2020/2/29 0029 14:38
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
        System.out.println("------------------contextPath");
        System.out.println(contextPath);
        String[] requireAuthPages = new String[]{
                "index",
        };

        String uri = request.getRequestURI();
        System.out.println("------------------uri");
        System.out.println(uri);

        // 如要使用StringUtils.remove注意使用common lang包而不是common lang3包
        uri = uri.substring(uri.lastIndexOf("/") + 1);
        String page = uri;
        System.out.println("------------------page");
        System.out.println(page);

        if(beginWith(page, requireAuthPages)){
            UserPojo user = (UserPojo) session.getAttribute("user");
            if(user==null) {
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    private boolean beginWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            //StringUtils来自于common lang3包中，需要添加对应配置
            if(StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
