<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Utils.Database" %>
<%!
    String email;
    Database database;
%>
<%
    email = (String)session.getAttribute("email");
    if(email == null) response.sendRedirect("login.jsp");
    database = Database.getInstance();
%>
<html lang="zh-CN">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>简测 · 我的主页</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/flat-ui.css">
    <link href="./css/home.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    简测
                </a>
            </li>
            <li>
                <a href="#" onclick="showPart('publish')">试卷发布</a>
            </li>
            <li>
                <a href="#" onclick="showPart('select_paper')">试卷选择</a>
            </li>
            <li>
                <a href="#" onclick="showPart('show_score')">成绩查询</a>
            </li>
            <li>
                <a href="logout">注销</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div id="publish">
            <h3>发布试题</h3>
            <form method="post" enctype="multipart/form-data">
                <p>请选择要上传的文件:</p>
                <input type="file" name="filename" size="100">
                <input type="submit" class="btn btn-primary" value="上传">
            </form>
            <form method="get">
                <input type="text" name="papername" placeholder="请输入试卷名称" size="50">
                <input type="submit" class="btn btn-primary" value="提交">
            </form>
        </div>
        <div id="select_paper" style="display: none;">
            <h3>选择试卷</h3>
            <%= database.getPaperList() %>
        </div>
        <div id="show_score" style="display: none;">
            <h3>查询成绩</h3>
            <p>您好,<%= (String)session.getAttribute("email") %>, 以下是您的成绩</p>
            <table id="score_table">
                <tr><td>试卷</td><td>成绩</td></tr>
                <%= database.getScore((String)session.getAttribute("email")) %>
            </table>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    function showPart(targetID) {
        if(targetID == 'publish') {
            $('#publish').show();
            $('#select_paper').hide();
            $('#show_score').hide();
        }
        if(targetID == 'select_paper') {
            $('#publish').hide();
            $('#select_paper').show();
            $('#show_score').hide();
        }
        if(targetID == 'show_score') {
            $('#publish').hide();
            $('#select_paper').hide();
            $('#show_score').show();
        }

    }
</script>

</body>

</html>

