<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Parking Stall Info Add Page</title>
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
    		    	    
    	    $("#parking_stall_info_add_form").submit(function() {
				var xiaoquId = $("#xiaoquId").val();
				var supplyDemandType = $("#supplyDemandType").val();
				var yourIdentity = $("#yourIdentity").val();
				var address = $("#address").val();
				var areaMeasure = $("#areaMeasure").val();
				var price = $("#price").val();
				var nickname = $("#nickname").val();
				var phone = $("#phone").val();				
				var title = $("#title").val();
				var content = $("#content").val();
				
				var json_parking_stall_info = {'xiaoquId': xiaoquId, 'supplyDemandType': supplyDemandType, 'yourIdentity': yourIdentity, 'address': address, 'areaMeasure': areaMeasure, 'price': price, 'nickname': nickname, 'phone':phone, 'title': title, 'content': content};
				
				alert(JSON.stringify(json_parking_stall_info));
                jQuery.ajax({  
                    type: 'POST',  
                    contentType: 'application/json',  
                    url: '/xiaoqubaserver/main/parking_stall_info',  
                    data: JSON.stringify(json_parking_stall_info),  
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
        <h3>增加车位寻租信息</h3>
        <form:form id="parking_stall_info_add_form" role="form" commandName="parkingStallInfo" action="/xiaoqubaserver/main/empty">  
        	
            <div class="form-group">
              <label for="xiaoquId">小区Id</label>
              <form:select path="xiaoquId" items="${xiaoquList}" cssClass="form-control" itemLabel="name" itemValue="id"/>
              <label id="xiaoquIdMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="supplyDemandType">供需</label>
              <form:select path="supplyDemandType" items="${supplyDemandTypeList}" cssClass="form-control"/>
              <label id="supplyDemandTypeMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="yourIdentity">您的身份</label>
              <form:select path="yourIdentity" items="${yourIdentityList}" cssClass="form-control"/>
              <label id="yourIdentityMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="address">地址</label>
              <input id="address" name="title" class="form-control" placeholder="" type="text" />
              <label id="addressMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="areaMeasure">面积</label>
              <input id="areaMeasure" name="title" class="form-control" placeholder="" type="text" />平米
              <label id="areaMeasureMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="price">租金</label>
              <input id="price" name="title" class="form-control" placeholder="" type="text" />
              <label id="priceMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="nickname">联系人</label>
              <input id="nickname" name="title" class="form-control" placeholder="" type="text" />
              <label id="nicknameMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
            
            <div class="form-group">
              <label for="phone">联系电话</label>
              <input id="phone" name="title" class="form-control" placeholder="" type="text" />
              <label id="phoneMsg" style="display:none;color:red;">&nbsp;</label>
            </div>            
        	
            <div class="form-group">
              <label for="title">标题</label>
              <input id="title" name="title" class="form-control" placeholder="" type="text" />
              <label id="titleMsg" style="display:none;color:red;">&nbsp;</label>
            </div>
        	
            <div class="form-group">
              <label for="exampleInputEmail2">描述</label>
              <textarea id="content" name="content" class="form-control" rows="5"></textarea>
              <label id="contentMsg" style="display:none;color:red;">&nbsp;</label>
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
   