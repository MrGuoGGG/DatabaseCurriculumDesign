<%--
  Created by IntelliJ IDEA.
  User: 16040
  Date: 2022/12/1
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有账号？</span> <a href="login.html">登录</a>
    </div>
    <form id="reg-form" action="/registerServlet" method="post">

        <table>

            <tr>
                <td>用户ID</td>
                <td class="inputs">
                    <input name="sid" type="text" id="sid">
                    <br>
                    <span id="ID_err" class="err_msg">${register_msg}</span>
                </td>

            </tr>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>

<script>
    document.getElementById("changeImg").onclick = function () {
        document.getElementById("checkCodeImg").src = "/brand-demo/checkCodeServlet?"+new Date().getMilliseconds();
    }
</script>

</body>
</html>