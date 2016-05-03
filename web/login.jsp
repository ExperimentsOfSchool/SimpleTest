<%--
  Created by IntelliJ IDEA.
  User: Lawrence
  Date: 5/1/16
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String email;
%>
<%
    email = (String)session.getAttribute("email");
    if(email != null) response.sendRedirect("home.jsp");
%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">


    <title>简测 · 登陆</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/flat-ui.css" rel="stylesheet">
    <link href="./css/signin.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <form class="form-signin" action="loginAccess" method="post">
        <h3 align="center" class="form-signin-heading">简测</h3>
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱" name="email" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" name="password" required>
        <button class="btn btn-lg btn-info btn-block" type="submit">登陆</button><p align="center">尚未加入?<a href="signup.jsp">点此注册</a></p>
    </form>

</div> <!-- /container -->


</body>
</html>
