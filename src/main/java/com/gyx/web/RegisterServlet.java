package com.gyx.web;

import com.gyx.pojo.S_User;
import com.gyx.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post中文乱码
        req.setCharacterEncoding("UTF-8");//设置字符输入流的编码

        //1.获取用户信息
        String sid = req.getParameter("sid");
        String sname = req.getParameter("username");
        String spassword = req.getParameter("password");

        //2.封装用户信息
        S_User s_user = new S_User();
        s_user.setSid(sid);
        s_user.setSname(sname);
        s_user.setSpassword(spassword);
        System.out.println(s_user);

        //3.调用service判断注册成功与否
        UserService userService = new UserService();
        boolean flag = userService.register(s_user);

        if (flag == true) {
            //注册成功,跳转到登陆页面
            req.setAttribute("register_msg", "注册成功,请登录");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            //注册失败
            req.setAttribute("register_msg", "用户id或用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
