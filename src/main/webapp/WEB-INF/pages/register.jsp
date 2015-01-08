<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Register Page</title>
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
	
    <script type="text/javascript">
    
	$(document).ready(function(){
		    	    
	    $("#user_add_form").submit(function() {
			var phone = $("#phone").val();
			var username = $("#username").val();
			var password = $("#password").val();
			var confirmPassword = $("#confirmPassword").val();
			var firstname = $("#firstname").val();
			var nickname = $("#nickname").val();
			var address = $("#address").val();
			var companyName = $("#companyName").val();
			var xiaoquId = $("#xiaoquId").val();
			var role = $("#role").val();
			var email = $("#email").val();
			
			
			var json_user = {'phone': phone, 'username': username, 'password': password, 
					'confirmPassword': confirmPassword, 'firstname': firstname, 
					'nickname': nickname, 'address': address,'companyName': companyName, 'xiaoquId': xiaoquId,'role': role, 'email': email};
			
			alert(JSON.stringify(json_user));
            jQuery.ajax({  
                type: 'POST',  
                contentType: 'application/json',  
                url: '/xiaoqubaserver/main/user',  
                data: JSON.stringify(json_user),  
                dataType: 'json',  
                success: function(data){  
                    alert("新增成功！" + JSON.stringify(data));  
                },  
                error: function(data){  
                    alert("error! " + JSON.stringify(data))  
                }  
            });
	    	
			return false;
	    });
		
	});	
    
    </script>
</head>
<body>

<%@include file="header.jsp" %>


<div class="container">
    <div class="row">
      <div class="col-md-12">
        <h3>增加公告</h3>
        <form:form id="user_add_form" role="form" commandName="user" action="/xiaoqubaserver/main/empty">  
        	
            <div class="form-group">
              <label for="phone">电话</label>
              <input id="phone" name="phone" class="form-control" placeholder="" type="text" />
              <label id="phoneMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="username">用户名</label>              
              <input id="username" name="username" class="form-control" placeholder="" type="text" />
              <label id="usernameMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="password">密码</label>
              <input id="password" name="password" class="form-control" placeholder="" type="password" />
              <label id="passwordMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="confirmPassword">确认密码</label>
              <input id="confirmPassword" name="confirmPassword" class="form-control" placeholder="" type="password" />
              <label id="confirmPasswordMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="firstname">姓名</label>
              <input id="firstname" name="firstname" class="form-control" placeholder="" type="text" />
              <label id="firstnameMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="nickname">昵称</label>
              <input id="nickname" name="nickname" class="form-control" placeholder="" type="text" />
              <label id="nicknameMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="address">地址</label>
              <input id="address" name="address" class="form-control" placeholder="" type="text" />
              <label id="addressMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="companyName">公司名称</label>
              <input id="companyName" name="companyName" class="form-control" placeholder="" type="text" />
              <label id="companyNameMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="xiaoquId">小区ID</label>
              <form:select path="xiaoquId" items="${xiaoquList}" cssClass="form-control" itemLabel="name" itemValue="id"/>
              <label id="xiaoquIdMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="role">用户角色</label>
              <form:select path="role" items="${userRoleList}" cssClass="form-control"/>
              <label id="roleMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="email">邮箱</label>
              <input id="email" name="email" class="form-control" placeholder="" type="text" />
              <label id="emailMsg" style="display:none;color:red;">&nbsp;</label>
            </div>

            <div class="form-group">
              <input type="submit" class="btn btn-default" value="提交"/>
            </div>
            
            
        </form:form>  
      </div>
    </div>
</div>
	
</body>
</html>
   