<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="path.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>功能菜单</title>
<script src="/teacher/admanage/js/cebian3.js"></script>
<script src="/teacher/admanage/js/jquery-1.91.js"></script>
<link type="text/css" rel="stylesheet" href="/teacher/admanage/css/cebian3.css" />
<link type="text/css" rel="stylesheet" href="/teacher/admanage/css/styles.css" />








<style>
li ul {
	display: none;
	margin-right: 1px;
}

ul, li {
	list-style-type: none;
	margin-right: 0px;
	padding-left: 0px;
}

.child li a {
	color: #000cdc;
}

.child li {
	margin-bottom: 2px;
	margin-top: 2px;
}

.child {
	margin-left: 20px;
}
</style>
<link rel="stylesheet" type="text/css" href="admanage/css/styles.css" />
<script>
	$(document).ready(

	function() {
		var mainM = $("ul>li>ul");
		var mainMenu = $("ul>li>a");
		mainMenu.click(function() {
			//mainM.not($(this).nextAll()).hide("slow");
			$(this).nextAll().slideToggle();
		});
	});
</script>

</head>

<body LINK="#FFFFFF" marginwidth="1" marginheight="1" topmargin="0"
	leftmargin="0" bgcolor="#99CCFF" text="#FFFFFF" vlink="#FFFFFF"
	alink="#FFFFFF">

	<ul>



  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; 权限管理</span>
 <div id="mySidenav" class="sidenav">
<a href="queryAll" target="text">用户管理</a>
<a href="searchAll1" target="text">帖子管理</a>
 
</div> 




		
		
		<!-- 
		 <li><a href="#" onclick="return false;">权限管理</a>
			<ul class="child">
				<li><a
					href="queryAll"
					target="text">用户管理</a></li>
				<li><a
					href="searchAll"
					target="text">帖子管理</a></li>
			</ul></li>
 -->
	</ul> 
</body>
</html>
