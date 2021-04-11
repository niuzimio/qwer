<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="path.jsp"%>
<html>
<head>
<base href="<%=basePath%>"> 
<title>登录系统</title>

<!-- 路径在xml配置静态资源 -->
<link rel="stylesheet" type="text/css" href="admanage/css/styles.css" />
<script type="text/javascript" src="admanage/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(":button").click(function(){
		var uname = $("[name=username]").val();
		var upass = $("[name=password]").val();
		//发送ajax请求
		$.getJSON("login",{username:uname,password:upass},function(jsondata){
			//alert(jsondata);                                                                     /////json
			if(jsondata=="2"){
				$("#error").html("账户被禁用！");
			}else if(jsondata=="0"){
				$("#error").html("用户名或密码错误！！");
			}else{
				//跳转到成功页面
				window.location="admanage/";
			}
		});
	});
});
</script>
</head>

<body >
	<h1> 后台管理系统 </h1>
	<hr />
	<div align="center">
	<form action="login" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input name="username" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="button" value="登录" /></td>
			</tr>
			<tr>
				<td colspan="2"><span style="color: red">${message }</span></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
