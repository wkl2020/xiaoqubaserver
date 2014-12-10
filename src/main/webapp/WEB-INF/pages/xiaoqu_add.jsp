<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Xiaoqu Add Page</title>
	<link href='<c:url value="/main/css/jquery.ui.theme.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript" src='<c:url value="/main/js/jquery-1.11.0.min.js"></c:url>'></script>
    
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-en.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-cn.js"></c:url>'></script>
	
	<script src="js/i18n/jquery.i18n.properties-1.0.9.js" type="text/javascript"></script>
	<script src="js/i18n/i18n_load.js" type="text/javascript"></script>
	
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		    	    
    	    $("#xiaoqu_add_form").submit(function() {
				var name = $("#name").val();
				var description = $("#description").val();
				var address = $("#address").val();
				var owner = $("#owner").val();
				var x = $("#x").val();
				var y = $("#y").val();
				var city = $("#city").val();
				
				var json_xiaoqu = {'name': name, 'description': description, 'address': address, 'owner': owner, 'x': x, 'y': y, 'city': city};
				
				alert(JSON.stringify(json_xiaoqu));
                jQuery.ajax({  
                    type: 'POST',  
                    contentType: 'application/json',  
                    url: '/xiaoqubaserver/main/xiaoqu',  
                    data: JSON.stringify(json_xiaoqu),  
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
	<form id="xiaoqu_add_form">
	  <table align="center" style="padding: 100px">
		<tr>
			<td>小区名称* </td>
		</tr>
		<tr>
			<td><input id="name" name="name" type="text" /> <label id="nameMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>描述</td>
		</tr>
		<tr>
			<td><input id="description" name="description" type="text" /> <label id="descriptionMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>地址* </td>
		</tr>
		<tr>
			<td><input id="address" name="address" type="text" /> <label id="addressMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>创建者* </td>
		</tr>
		<tr>
			<td><input id="owner" name="owner" type="text" /> <label id="ownerMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>x </td>
		</tr>
		<tr>
			<td><input id="x" name="x" type="text" /> <label id="xMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>y </td>
		</tr>
		<tr>
			<td><input id="y" name="y" type="text" /> <label id="yMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		<tr>
			<td>城市</td>
		</tr>
		<tr>
			<td><input id="city" name="city" type="text" /> <label id="cityMsg" style="color:red">&nbsp;</label></td>
		</tr>
		
		
		
		<tr>
		<td><input type="submit" value="提交"/></td>
		</tr>
		</table>
	</form>

</div>  
	
</body>
</html>
   