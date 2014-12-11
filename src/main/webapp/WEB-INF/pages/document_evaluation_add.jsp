<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Document Evaluation Add Page</title>
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

<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
      <div class="col-md-12">
        <h3>增加公告评论</h3>
        <form id="documentEvaluation_add_form" role="form">
        	
            <div class="form-group">
              <label for="documentId">公告Id</label>              
              <input id="documentId" name="documentId" class="form-control" placeholder="" type="text" />
              <label id="documentIdMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="documentType">公告类型</label>              
              <input id="documentType" name="documentType" class="form-control" placeholder="" type="text" />
              <label id="documentTypeMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="evaluationType">好评/差评</label>              
              <input id="evaluationType" name="evaluationType" class="form-control" placeholder="" type="text" />
              <label id="evaluationTypeMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="nickname">评论者昵称</label>              
              <input id="nickname" name="nickname" class="form-control" placeholder="" type="text" />
              <label id="nicknameMsg" style="display:none;color:red;">&nbsp;</label>
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
   