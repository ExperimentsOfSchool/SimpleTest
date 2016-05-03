<%--
  Created by IntelliJ IDEA.
  User: Lawrence
  Date: 5/1/16
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Paper.*" %>
<%! Paper testPaper;
    String email;
%>
<%
    String path = request.getSession().getServletContext().getRealPath("/excel");
    email = (String)session.getAttribute("email");
    if(email == null) response.sendRedirect("login.jsp");
    String paperName = (String)session.getAttribute("papername");
    String paperFileName = (String)session.getAttribute("filename");
    if(paperName != null && paperFileName != null) {
        testPaper = new Paper(paperName, path, paperFileName);
        session.removeAttribute("papername");
        session.removeAttribute("filename");
    } else {
        response.sendRedirect("home.jsp");
    }

%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>简测 · 在线测试平台</title>

    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/flat-ui.css" rel="stylesheet">
    <link href="./css/paper.css" rel="stylesheet">

    <script type="text/javascript" herf="./js/flat-ui.min.js"></script>
</head>

<body>

<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="./index.jsp">简测</a>
    </div>
    <div class="collapse navbar-collapse" id="navbar-collapse-01">

        <form class="navbar-form navbar-right" action="#" role="search">
            <div class="form-group">
                <div class="input-group">
                    <input class="form-control" id="navbarInput-01" type="search" placeholder="搜素试卷...">
          <span class="input-group-btn">
            <button type="submit" class="btn"><span class="fui-search"></span></button>
          </span>
                </div>
            </div>
            <div class="form-group" style="margin-left: 10px;">
            </div>
        </form>
    </div><!-- /.navbar-collapse -->
</nav><!-- /navbar -->


<div class="container">
    <h2 align="center"><%= testPaper.getPaperName() %></h2>
    <form method="post" action="judgeAnswer">
        <input class="rs_only" name="paperid" value="<%= testPaper.getPaperId() %>" style="display: none" />
        <%= testPaper.printIntoHTML() %>
        <div style="margin: 0 auto;"><button class="btn btn-primary btn-lg" type="submit">提交试卷</button></div>
    </form>

</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>


</body>
</html>

