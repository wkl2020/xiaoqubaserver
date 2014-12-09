<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Document Evaluation Add Page</title>
	<link href='<c:url value="/main/css/jquery.ui.theme.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript" src='<c:url value="/main/js/jquery-1.11.0.min.js"></c:url>'></script>
    
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-en.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-cn.js"></c:url>'></script>
	
	<script src="js/i18n/jquery.i18n.properties-1.0.9.js" type="text/javascript"></script>
	<script src="js/i18n/i18n_load.js" type="text/javascript"></script>
	
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		    	    
    	    $("#documentEvaluation_add_form").submit(function() {
				var documentId = $("#documentId").val();
				var documentType = $("#documentType").val();
				var evaluationType = $("#evaluationType").val();
				var nickname = $("#nickname").val();
				
				var json_documentEvaluation = {'documentId': documentId, 'documentType': documentType, 'evaluationType': evaluationType, 'nickname': nickname};
				
				alert(JSON.stringify(json_documentEvaluation));
                jQuery.ajax({  
                    type: 'POST',  
                    contentType: 'application/json',  
                    url: '/xiaoqubaserver/main/documentEvaluation',  
                    data: JSON.stringify(json_documentEvaluation),  
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

	<div style="text-align:right;margin-right:10px;">
		<a href="toHostManagePage"><button id="hostManageBtn">主机管理</button></a>&nbsp;
		<a href="toUserManagePage"><button id="userManageBtn">用户管理</button></a>&nbsp;
		<a href="toRegisterUsrPage"><button id="registerBtn">普通用户注册</button></a>&nbsp;
		<a href="index"><button id="indexBtn">主页面</button></a>&nbsp;<a href="logout"><button id="logoutBtn">退出</button></a>&nbsp;
	</div>

<div>
	<form id="documentEvaluation_add_form">
	  <table align="center" style="padding: 100px">
		<tr>
			<td>公告Id* </td>
		</tr>
		<tr>
			<td><input id="documentId" name="documentId" type="text" /> <label id="documentIdMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>公告类型</td>
		</tr>
		<tr>
			<td><input id="documentType" name="documentType" type="text" /> <label id="documentTypeMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>好评/差评* </td>
		</tr>
		<tr>
			<td><input id="evaluationType" name="evaluationType" type="text" /> <label id="evaluationTypeMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>评论者昵称* </td>
		</tr>
		<tr>
			<td><input id="nickname" name="nickname" type="text" /> <label id="nicknameMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		
		
		<tr>
		<td><input type="submit" value="提交"/></td>
		</tr>
		</table>
	</form>

</div>  
	
</body>
</html>
   