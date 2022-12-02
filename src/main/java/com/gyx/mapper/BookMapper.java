package com.gyx.mapper;

import com.gyx.pojo.Book;

import java.util.List;

public interface BookMapper {
    //查询所有书籍信息
    List<Book> selectAll();

    //添加新书
    void addBook(Book book);

    //根据索书号查询
    Book selectByBid(String bid);

    //修改书籍信息
    void updateBook(Book book);

    //删除书籍信息
    void deleteBook(String bid);
}
