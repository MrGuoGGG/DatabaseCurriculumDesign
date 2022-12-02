package com.gyx.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//登陆验证过滤器
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        String[] urls={"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet"};
        //获取当前访问的资源路径
        String url = req.getRequestURL().toString();

        //循环判断
        for (String u:urls){
            if(url.contains(u)){
                //放行
                chain.doFilter(request, response);

                return;
            }
        }

        //1.判断session中是否有sUser
        HttpSession session = req.getSession();
        Object sUser = session.getAttribute("sUser");
        //2.判断sUser是否为null
        if(sUser!=null){
            //已经登陆
            //放行
            chain.doFilter(request, response);
        }else {
            //没有登录，拦截并跳转到登陆页面
            req.setAttribute("login_msg","您尚未登陆");
            req.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
