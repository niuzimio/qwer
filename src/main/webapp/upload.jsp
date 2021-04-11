<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文件上传</title>
    
  </head>
  
  <body>
   <form action="upload" method="post" enctype="multipart/form-data">
   	新闻标题：<input name="title"> <p>
   	新闻图片：<input type="file" name="myfile"> <p>
   	<input type="submit" value="上传">
   </form>
  </body>
</html>
