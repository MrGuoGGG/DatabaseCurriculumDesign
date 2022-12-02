package com.gyx.web;

import com.gyx.pojo.S_User;
import com.gyx.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //解决post中文乱码
        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码

        //1.接受用户名和密码
        String susername = request.getParameter("username");
        String spassword = request.getParameter("password");


        //2.调用service查询
        UserService userService = new UserService();
        S_User sUser = userService.login(susername, spassword);

        //3.判断
        if (sUser != null) {
            //登陆成功
            //将登陆成功后的S_User对象存入到session中
            HttpSession session = request.getSession();
            session.setAttribute("sUser",sUser);

            //跳转到book.jsp
            String contextPath = request.getContextPath();
            response.sendRedirect("/selectAllBooksServlet");

        } else {
            //登陆失败
            //存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");

            //跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
