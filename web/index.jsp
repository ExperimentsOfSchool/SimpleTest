<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: Lawrence
  Date: 5/1/16
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- <link rel="icon" href="http://v3.bootcss.com/favicon.ico"> -->

    <title>简测 · 在线测试平台</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/flat-ui.css" rel="stylesheet">


    <script type="text/javascript" herf="./js/flat-ui.min.js"></script>
</head>

<body style="background: #eee">

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

<!-- Main jumbotron for a primary marketing message or call to action -->

<div class="container" id="head" >
    <h1>简测</h1>
    <br />
    <br />
    <p>一个简洁、清爽的测试平台。</p>
    <br />
    <br />
    <br />
    <p><a class="btn btn-primary btn-lg" href="./login.jsp" role="button">开始测试</a></p>
</div>


<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>简洁</h2>
            <p>页面基于BootStrap和Flat UI,简洁清爽,易于使用. </p>
            <p><a class="btn btn-default" href="http://www.bootcss.com" role="button">了解更多</a></p>
        </div>
        <div class="col-md-4">
            <h2>轻巧</h2>
            <p>使用了先进的Apache POI技术,仅需上传Excel文档即可自动生成试卷.</p>
            <p><a class="btn btn-default" href="http://poi.apache.org" role="button">了解更多</a></p>
        </div>
        <div class="col-md-4">
            <h2>高效</h2>
            <p>使用MySQL高性能服务器,面对大量试题能够沉着应对,快速处理.</p>
            <p><a class="btn btn-default" href="http://www.mysql.com" role="button">了解更多</a></p>
        </div>
    </div>

    <hr>

</div> <!-- /container -->
<footer>
    <p align="center">Copyright 2016. Designed By Lawrence in NEU</p>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>


</body>
</html>
