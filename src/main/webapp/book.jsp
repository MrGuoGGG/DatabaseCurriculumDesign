<%--
  Created by IntelliJ IDEA.
  User: 灰原哀
  Date: 2022/11/27
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>${sUser.sname},欢迎您</h1>

<input type="button" value="添加书籍" id="addBook"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>索书号</th>
        <th>书名</th>
        <th>作者</th>
        <th>语言</th>
    </tr>
    <tr>
        <jsp:useBean id="books" scope="request" type="java.util.List"/>
        <c:forEach items="${books}" var="book" varStatus="status">
            <td>${book.bid}</td>
            <td>${book.bname}</td>
            <td>${book.bauthor}</td>
            <td>${book.blanguage}</td>

            <td><a href="/selectByBidServlet?bid=${book.bid}">修改信息</a> <a href="/deleteBookServlet?bid=${book.bid}">删除该书</a> </td>
    </tr>
    </c:forEach>
</table>

<script>
    document.getElementById("addBook").onclick=function (){
        location.href="/addBook.jsp";
    }
</script>
</body>
</html>
