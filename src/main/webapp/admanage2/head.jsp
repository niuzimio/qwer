
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="path.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<TITLE>欢迎使用！</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<link rel="stylesheet" href="/auth/layui/css/layui.css">
<LINK href="css/styles.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.3790.3959" name=GENERATOR>
</HEAD>
<BODY
	style="BACKGROUND-IMAGE: url(/image/header-bg.jpg); MARGIN: 0px; BORDER-BOTTOM: #6fbaf1 6px solid; TEXT-ALIGN: left; scroll: no">
	<TABLE width="100%">
		<TBODY>
			<TR>
				<TD><SPAN style="FONT-WEIGHT: bold; FONT-SIZE: 33px">&nbsp;
						学习论坛管理系统 </SPAN></TD>

				<TD style="TEXT-ALIGN: right" valign=bottom><B> 欢迎您:</B>
					${loginUser.uname} [<a href="http://www.localhost:8080/teacher/"
					target="_top" onclick="confirm('您确定要退出吗');">退出</a>]</TD>
			</TR>
		</TBODY>
	</TABLE>
</BODY>
<body>
</body>
</HTML>
