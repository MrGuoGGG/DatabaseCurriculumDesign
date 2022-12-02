<%--
  Created by IntelliJ IDEA.
  User: 灰原哀
  Date: 2022/11/27
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加新书</title>
</head>
<body>
<h3>添加新书</h3>
<form action="/addBookServlet" method="post">
    索书号：<input name="bid"><br>
    书籍名称：<input name="bname"><br>
    作者：<input name="bauthor"><br>
    语言：<input name="blanguage"><br>

    <input type="submit" value="提交">
</form>
</body>
</html>
