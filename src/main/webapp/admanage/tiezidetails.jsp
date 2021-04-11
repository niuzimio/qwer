<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="path.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>帖子详情</title>
</head>
<body>
	<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="tid" value="${tiezi.tid }">
		<div style="color:blue; FONT-SIZE: 33px ">帖子标题：</div><div style=" FONT-SIZE: 28px ">${tiezi.title }</div>
		
		<div style="color:blue; FONT-SIZE: 33px ">帖子内容：</div><div style=" FONT-SIZE: 28px ">${tiezi.content }</div>
	</form>
</body>
</html>