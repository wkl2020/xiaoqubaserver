<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Document Add Page</title>
	<link href='<c:url value="/main/css/jquery.ui.theme.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript" src='<c:url value="/main/js/jquery-1.11.0.min.js"></c:url>'></script>
    
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-en.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-cn.js"></c:url>'></script>
	
	<script src="js/i18n/jquery.i18n.properties-1.0.9.js" type="text/javascript"></script>
	<script src="js/i18n/i18n_load.js" type="text/javascript"></script>
	
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		    	    
    	    $("#document_add_form").submit(function() {
				var xiaoquId = $("#xiaoquId").val();
				var documentType = $("#documentType").val();
				var title = $("#title").val();
				var content = $("#content").val();
				var expireDate = $("#expireDate").val();
				var owner = $("#owner").val();
				var manageCompany = $("#manageCompany").val();
				
				var json_document = {'xiaoquId': xiaoquId, 'documentType': documentType, 'title': title, 'content': content, 'expireDate': expireDate, 'owner': owner, 'manageCompany': manageCompany};
				
				alert(JSON.stringify(json_document));
                jQuery.ajax({  
                    type: 'POST',  
                    contentType: 'application/json',  
                    url: '/xiaoqubaserver/main/document',  
                    data: JSON.stringify(json_document),  
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
	<form id="document_add_form">
	  <table align="center" style="padding: 100px">
		<tr>
			<td>小区Id* </td>
		</tr>
		<tr>
			<td><input id="xiaoquId" name="xiaoquId" type="text" /> <label id="xiaoquIdMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>文档类型 </td>
		</tr>
		<tr>
			<td><input id="documentType" name="documentType" type="text" /> <label id="documentTypeMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>文档标题* </td>
		</tr>
		<tr>
			<td><input id="title" name="title" type="text" /> <label id="titleMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>文档内容* </td>
		</tr>
		<tr>
			<td><textarea id="content" name="content" rows="10" cols="80"></textarea> <label id="contentMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>过期时间 </td>
		</tr>
		<tr>
			<td><input id="expireDate" name="expireDate" type="text" /> <label id="expireDateMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>发布者 </td>
		</tr>
		<tr>
			<td><input id="owner" name="owner" type="text" /> <label id="ownerMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>发布公司名称</td>
		</tr>
		<tr>
			<td><input id="manageCompany" name="manageCompany" type="text" /> <label id="manageCompanyMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		
		
		<tr>
		<td><input type="submit" value="提交"/></td>
		</tr>
		</table>
	</form>

</div>  
	
</body>
</html>
   