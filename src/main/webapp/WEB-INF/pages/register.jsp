<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Register Page</title>
	<link href='<c:url value="/main/css/jquery.ui.theme.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript" src='<c:url value="/main/js/jquery-1.11.0.min.js"></c:url>'></script>
    
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-en.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-cn.js"></c:url>'></script>
	
	<script src="js/i18n/jquery.i18n.properties-1.0.9.js" type="text/javascript"></script>
	<script src="js/i18n/i18n_load.js" type="text/javascript"></script>
	
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		
    	});		
    
    </script>
</head>
<body>

<%@include file="header.jsp" %>

<div>
	<form:form method="Post" action="${pageContext.request.contextPath}/main/createUser" commandName="user" modelAttribute="user">
		<table align="center" style="padding: 100px">
			<tr>
				<td>用户名* </td>
			</tr>
		<tr>
			<td><form:input path="username" /> <FONT color="red"><form:errors path="username" /></FONT></td>
		</tr>
		
		<tr>
			<td>密码* </td>
		</tr>
		<tr>
			<td><form:password path="password" /> <FONT color="red"><form:errors path="password" /></FONT></td>
		</tr>
		
		<tr>
			<td>确认密码* </td>
		</tr>
		<tr>
			<td><form:password path="confirmPassword" /> <FONT color="red"><form:errors path="confirmPassword" /></FONT></td>
		</tr>
		
		<tr>
			<td>姓: </td>
		</tr>
		<tr>
			<td><form:input path="firstname" /> <FONT color="red"><form:errors path="firstname" /></FONT></td>
		</tr>
		
		<tr>
			<td>名: </td>
		</tr>
		<tr>
			<td><form:input path="lastname" /> <FONT color="red"><form:errors path="lastname" /></FONT></td>
		</tr>
		
		<tr>
			<td>昵称: </td>
		</tr>
		<tr>
			<td><form:input path="nickname" /> <FONT color="red"><form:errors path="nickname" /></FONT></td>
		</tr>
		
		<tr>
			<td>地址: </td>
		</tr>
		<tr>
			<td><form:input path="address" /> <FONT color="red"><form:errors path="address" /></FONT></td>
		</tr>
		
		<tr>
			<td>公司名称: </td>
		</tr>
		<tr>
			<td><form:input path="companyName" /> <FONT color="red"><form:errors path="companyName" /></FONT></td>
		</tr>
		
		<tr>
			<td>小区ID: </td>
		</tr>
		<tr>
			<td><form:input path="xiaoquId" /> <FONT color="red"><form:errors path="xiaoquId" /></FONT></td>
		</tr>
		
		<tr>
			<td>电话* </td>
		</tr>
		<tr>
			<td><form:input path="phone" /> <FONT color="red"><form:errors path="phone" /></FONT></td>
		</tr>
		
		<tr>
			<td>用户角色* </td>
		</tr>
		<tr>
			<td><form:select path="role" items="${userRoleList}" /><FONT color="red"><form:errors path="role" /></FONT></td>
		</tr>
		
		<tr>
			<td>邮箱: </td>
		</tr>
		<tr>
			<td><form:input path="email" /> <FONT color="red"><form:errors path="email" /></FONT></td>
		</tr>
		
		<tr>
		<td><input type="submit" value="提交" /></td>
		</tr>
		</table>
	</form:form>
</div>  
	
</body>
</html>
   