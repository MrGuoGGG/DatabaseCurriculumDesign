package com.gyx.web;

import com.gyx.pojo.Book;
import com.gyx.service.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByBidServlet")
public class SelectByBidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService=new BookService();
        //处理POST请求中文乱码问题
        request.setCharacterEncoding("utf-8");
        //1.接收bid
        String bid = request.getParameter("bid");
        //2.调用service查询
        Book book = bookService.selectByBid(bid);
        System.out.println(book);
        //3.将book存储到request域中
        request.setAttribute("book",book);
        //4.转发到updateBook.jsp
        request.getRequestDispatcher("/updateBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
