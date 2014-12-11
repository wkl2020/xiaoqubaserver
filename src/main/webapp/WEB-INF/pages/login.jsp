<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login Page</title>
	<link href='<c:url value="/main/css/jquery.ui.theme.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/flat-ui.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/vendor/bootstrap.min.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/demo.css"/>' type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript" src='<c:url value="/main/js/jquery-1.11.0.min.js"></c:url>'></script>
    
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-en.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-cn.js"></c:url>'></script>
	
	<script src="js/i18n/jquery.i18n.properties-1.0.9.js" type="text/javascript"></script>
	<script src="js/i18n/i18n_load.js" type="text/javascript"></script>
	
	<script type="text/javascript" src='<c:url value="/main/dist/js/flat-ui.min.js"></c:url>'></script>
    <script type="text/javascript" src='<c:url value="/main/dist/js/application.js"></c:url>'></script>
	
    <script type="text/javascript">
    
    	$(document).ready(function(){
			if ($("#j_username").val() == "admin") {
				$("#j_username").val("");
				$("#j_password").val("");
			}
    	});		
    
    </script>
</head>
<body>

<div class="container">
    <div class="row">
      <div class="col-md-12">
        <h3>登录</h3>
        <form action="${pageContext.request.contextPath}/main/j_spring_security_check" method="post" role="form">
        	
            <div class="form-group">
              <label for="j_username">用户名</label>              
              <input id="j_username" name="j_username" value="" class="form-control" placeholder="" type="text" />
              <form:errors path="*"/>
            </div>
            
            <div class="form-group">
              <label for="j_password">密码</label>              
              <input id="j_password" name="j_password" value="" class="form-control" placeholder="" type="password" />
            </div>
            
            <div class="form-group">
              <input class="btn btn-default" type="submit" value="登陆"/>
            </div>
            
        </form>
      </div>
    </div>
</div>

</body>
</html>
