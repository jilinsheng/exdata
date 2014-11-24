<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String type=request.getParameter("type");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery/demo/demo.css">
<script type="text/javascript" src="<%=basePath%>jquery/jquery.min.js"></script>
<script type="text/javascript"src="<%=basePath%>jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery/locale/easyui-lang-zh_CN.js"></script> --%>
<title>数据查询</title>
</head>
<body>
<table id="list_data" 
		style="width:$(document.body).width();height:$(document.body).height();">
	</table>
<script>
	//datagrid初始化 
	$('#list_data').datagrid({
	    title:'查询结果',
	    iconCls:'icon-search',//图标  
	    url:'<%=basePath%>page/QueryData?type=<%=type%>',
		remoteSort : false,
		singleSelect : true,//是否单选  
		pagination : true,//分页控件  
		rownumbers : true,
		pageNumber:1,
		pageSize:20,
		pageList:[ 5, 10, 15 ,20,25,30],
		footer:'#ft',
		columns:[[  
				 {field:'masteridcard',title:'主申请人身份号'},
				 {field:'mastername',title:'主申请人姓名'},
				 {field:'memberidcard',title:'成员身份证号'},
				 {field:'membername',title:'成员姓名'},
				 {field:'sex',title:'性别'},
				 {field:'personstate',title:'状态'},
				 {field:'relmaster',title:'与户主关系'},
        ]],
		loadFilter: function(data){
			if (data.d){
				return data.d;
			} else {
				for (var i = 0; i < data.rows.length; i++) {
					for (var att in data.rows[i]) {
						if(data.rows[i][att]=="null"){
							data.rows[i][att]="";
						}
		               }
				}
				return data;
			}
		}
	});
	
	</script>
	<script type="text/javascript">
		$(function(){
			var pager = $('#list_data').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons: ft
			});			
		})
	</script>
	<div id="ft">
		<a href="<%=basePath%>page/Exdata?type=cszb" target="_blank" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
	</div>
</body>
</html>