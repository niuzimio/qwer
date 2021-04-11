<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学习论坛管理系统</title>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>/admanage/css/styles.css">
  </head>
  
 <frameset rows="70,*,50" frameborder="no">
	<frame src="<%=basePath%>/admanage2/head.jsp" scrolling="no">
	<frameset cols="200,*">
		<frame src="<%=basePath%>/admanage2/menu.jsp" name="menu"  scrolling="auto">
		<frame src="<%=basePath%>/admanage2/main.jsp" name="text">
	</frameset>
	<frame src="<%=basePath%>/admanage2/footer.jsp" scrolling="no" >
</frameset>
</html>
