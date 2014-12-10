<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Document Comment Add Page</title>
	<link href='<c:url value="/main/css/jquery.ui.theme.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript" src='<c:url value="/main/js/jquery-1.11.0.min.js"></c:url>'></script>
    
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-en.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-cn.js"></c:url>'></script>
	
	<script src="js/i18n/jquery.i18n.properties-1.0.9.js" type="text/javascript"></script>
	<script src="js/i18n/i18n_load.js" type="text/javascript"></script>
	
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		    	    
    	    $("#documentComment_add_form").submit(function() {
				var documentId = $("#documentId").val();
				var documentType = $("#documentType").val();
				var content = $("#content").val();
				var nickname = $("#nickname").val();
				
				var json_documentComment = {'documentId': documentId, 'documentType': documentType, 'content': content, 'nickname': nickname};
				
				alert(JSON.stringify(json_documentComment));
                jQuery.ajax({  
                    type: 'POST',  
                    contentType: 'application/json',  
                    url: '/xiaoqubaserver/main/documentComment',  
                    data: JSON.stringify(json_documentComment),  
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

<div>
	<form id="documentComment_add_form">
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
			<td>公告评论内容* </td>
		</tr>
		<tr>
			<td><textarea id="content" name="content" rows="10" cols="80"></textarea> <label id="contentMsg" style="color:red">&nbsp;</label></td>
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
   