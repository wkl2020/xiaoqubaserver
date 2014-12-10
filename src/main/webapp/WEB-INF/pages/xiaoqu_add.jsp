<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Xiaoqu Add Page</title>
	<link href='<c:url value="/main/css/jquery.ui.theme.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/flat-ui.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/vendor/bootstrap.min.css"/>' type="text/css" rel="stylesheet"></link>
	
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

<div class="container">
    <div class="row">
      <div class="col-md-12">
        <h3>增加公告评论</h3>
        <form id="xiaoqu_add_form" role="form">
        	
            <div class="form-group">
              <label for="name">小区名称</label>              
              <input id="name" name="name" class="form-control" placeholder="" type="text" />
              <label id="nameMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="description">描述</label>              
              <input id="description" name="description" class="form-control" placeholder="" type="text" />
              <label id="descriptionMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="address">地址</label>              
              <input id="address" name="address" class="form-control" placeholder="" type="text" />
              <label id="addressMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="owner">创建者</label>              
              <textarea id="owner" name="owner" class="form-control" rows="5"></textarea>
              <label id="ownerMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="x">x</label>              
             <input id="x" name="x" class="form-control" placeholder="" type="text" />
              <label id="xMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="y">y</label>              
              <input id="y" name="y" class="form-control" placeholder="" type="text" />
              <label id="yMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="city">城市</label>              
              <input id="city" name="city" class="form-control" placeholder="" type="text" />
              <label id="cityMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <input type="submit" class="btn btn-default" value="提交"/>
            </div>
            
        </form>
      </div>
    </div>
</div>
	
</body>
</html>
   