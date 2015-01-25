<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Manage Parking List</title>
	<link href='<c:url value="/main/css/main.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/flat-ui.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/vendor/bootstrap.min.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/dist/css/demo.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/jqGrid.bootstrap.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/ui.jqgrid.css"/>' type="text/css" rel="stylesheet"></link>
	<link href='<c:url value="/main/css/jquery-ui.css"/>' type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript" src='<c:url value="/main/js/jquery-1.11.0.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/jquery.jqGrid.min.js"></c:url>'></script>
	<script src="js/window.js" type="text/javascript"></script>
    
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-en.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/main/js/i18n/grid.locale-cn.js"></c:url>'></script>
	
	<script src="js/i18n/jquery.i18n.properties-1.0.9.js" type="text/javascript"></script>
	<script src="js/i18n/i18n_load.js" type="text/javascript"></script>
	
    <script type="text/javascript">
    
    	$(document).ready(function(){
    		// I18n initlize
    		loadProperties();
    		
    		//document.title=$.i18n.prop('index.title'); 
    		
		
			$("#parkingListTable").jqGrid({
    			url:'/xiaoqubaserver/main/parking_stall_info/index?xiaoquId=1',
    			datatype: "json",
    			height: 450,
    			colNames:['ID', $.i18n.prop('parking.list.xiaoquId'), $.i18n.prop('parking.list.owner'), $.i18n.prop('parking.list.supplyDemandType'), $.i18n.prop('parking.list.yourIdentity'), $.i18n.prop('parking.list.price'), $.i18n.prop('parking.list.areaMeasure'), $.i18n.prop('parking.list.phone'), $.i18n.prop('parking.list.nickname'), $.i18n.prop('parking.list.commandCol')], 
				colModel:[ 
					{name:'id',index:'id', width:40, sorttype:"int"}, 
					{name:'xiaoquId',index:'xiaoquId', width:150}, 
					{name:'owner',index:'owner', width:150},
					{name:'supplyDemandType',index:'supplyDemandType', width:150},
					{name:'yourIdentity',index:'yourIdentity', width:150},
					{name:'price',index:'price', width:150},
					{name:'areaMeasure',index:'areaMeasure', width:150},
					{name:'phone',index:'phone', width:150},
					{name:'nickname',index:'nickname', width:150},
					{name:'commandCol',index:'commandCol', width:250, formatter: commandColFormatter}
				],
    			rowNum:10,
    			rowList:[10,20,30],
    			pager: '#parkingListPager',
    			sortname: 'create_date',
				sortorder: 'desc',
    			viewrecords: true,
    			multiselect: false,
				caption: "停车位信息",
				beforeSelectRow: function(rowId, e) {
				},
				onSelectRow: function(id){ 				
				}
    		});
    		jQuery("#parkingListTable").jqGrid('navGrid','#parkingListPager',{add:false,edit:false,del:false});
			
            
            
        	// Set grid width to #content
            $("#parkingListTable").jqGrid('setGridWidth', $("#content").width(), true);
    	});	
    	
    	
    	function commandColFormatter(cellvalue, options, rowdata) {    		
    		return "<button type='button' onclick='showDelConfirmPanel(\"" + rowdata.id + "\")'>"+$.i18n.prop('command.delete')+"</button>";
    	}
    
    </script>
</head>
<body>
	
<%@include file="header.jsp" %>

<div style="margin-left:20px;margin-right:20px;font-size: inheret;font-weight: 200;line-height: 2;color: inherit;">
	<div id="content">
		<table id="parkingListTable" class="table table-condensed"></table>
		<div id="parkingListPager"></div>
	</div>
</div>	
	
</body>
</html>