<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Document Add Page</title>
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
	
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
      <div class="col-md-12">
        <h3>增加公告</h3>
        <form id="document_add_form" role="form">
        	
            <div class="form-group">
              <label for="xiaoquId">小区Id</label>              
              <input id="xiaoquId" name="xiaoquId" class="form-control" placeholder="" type="text" />
              <label id="xiaoquIdMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="documentType">文档类型</label>
              <input id="documentType" name="documentType" class="form-control" placeholder=" "type="text" />
              <label id="documentTypeMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="title">文档标题</label>
              <input id="title" name="title" class="form-control" placeholder="" type="text" />
              <label id="titleMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="exampleInputEmail2">文档内容</label>
              <textarea id="content" name="content" class="form-control" rows="5"></textarea>
              <label id="contentMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="exampleInputEmail2">过期时间</label>
              <input id="expireDate" name="expireDate" class="form-control" placeholder="" type="text" />
              <label id="expireDateMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="exampleInputEmail2">发布者 </label>
              <input id="owner" name="owner" class="form-control" placeholder="" type="text" />
              <label id="ownerMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="exampleInputEmail2">发布公司名称</label>
              <input id="manageCompany" name="manageCompany" class="form-control" placeholder="" type="text" />
              <label id="manageCompanyMsg" style="display:none;color:red;">&nbsp;</label>
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
   