package com.gyx.web;

import com.gyx.pojo.Book;
import com.gyx.service.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求中文乱码问题
        request.setCharacterEncoding("utf-8");
        //1.调用BookService
        BookService bookService = new BookService();
        //2.接受表单提交的数据，并封装为Book对象
        String bid = request.getParameter("bid");
        String bname = request.getParameter("bname");
        String bauthor = request.getParameter("bauthor");
        String blanguage = request.getParameter("blanguage");
        //封装对象
        Book book = new Book();
        book.setBid(bid);
        book.setBname(bname);
        book.setBauthor(bauthor);
        book.setBlanguage(blanguage);
        //3.完成添加操作
        bookService.updateBook(book);
        //4.转发到查询所有的servlet
        request.getRequestDispatcher("/selectAllBooksServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
