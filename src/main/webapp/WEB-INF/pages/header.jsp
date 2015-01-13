<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>

	<div role="navigation" class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
            <span class="sr-only">Toggle navigation</span>
          </button>
          <a href="index" class="navbar-brand">XiaoQuBa</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">主页</a></li>
            <li><a href="#about">关于</a></li>
            <li><a href="#contact">联系我们</a></li>
            <li class="dropdown">
              <a data-toggle="dropdown" class="dropdown-toggle" href="#">导航 <b class="caret"></b></a>
              <ul class="dropdown-menu">			  
                <li><a href="toUserManagePage">用户管理</a></li>
                <li><a href="toRegisterUsrPage">用户注册</a></li>
                <li class="divider"></li>
                <li><a href="toXiaoquAdd">增加小区</a></li>
                <li class="divider"></li>
                <li><a href="toDocumentAdd">新增公告</a></li>
                <li><a href="toDocumentCommentAdd">新增公告评论</a></li>
				<li><a href="toDocumentEvaluationAdd">点赞公告</a></li>
				<li class="divider"></li>
				<li><a href="toParkingStallInfoAdd">增加车位寻租</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Default</a></li>
            <li class="active"><a href="./">Static top</a></li>
            <li><a href="login.html">登录</a></li>
            <li><a href="logout">退出</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    
    <script type="text/javascript" src='<c:url value="/main/dist/js/flat-ui.min.js"></c:url>'></script>
    <script type="text/javascript" src='<c:url value="/main/dist/js/application.js"></c:url>'></script>