<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8" isELIgnored="false"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="path.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="admanage/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="admanage/js/jquery-ui-1.8.4.custom.css">
<script src="admanage/js/jquery.1.4.2.js"></script>
<script type="text/javascript"
	src="admanage/js/jquery-ui-1.8.4.custom.min.js"></script>
<script type="text/javascript" src="admanage/js/jquery-ui-i18n.js"></script>
<script type="text/javascript">
	function del(id){
		if(confirm("您确定删除么？")){
			window.location="delete2?obj="+id;
		}
		return false;
	}
	function updatejsign(id){
		if(confirm("您确定修改么？")){
			window.location="updatejsign?tid="+id;
		}
		return false;
	}
	
	
	function nextPage(page){
		
		myform.pageNo.value=page;
		myform.submit();
	}
</script>
</head>

<body>
	<form action="searchAll1" name="myform" method="post">
	<!-- 隐藏域  存放当前页号 -->
		<input type="hidden" name="pageNo" value="${param.pageNo}"> <span
			style="font-weight: bold;">帖子管理</span>
		<table class="input_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="input_title">帖子标题</td>
				<td class="input_content">&nbsp; 
				<input name="title"
					value="${param.title}" />
				
				</td>
				<td class="input_uname">发帖人</td>
				<td class="input_content">&nbsp; 
				<input name="uname"
					value="${param.uname}" />
				</td>
				<td class="input_title">状态</td>
				<td class="input_content"><select name="jsign">
						<option value="-1">全部</option>
						<option value="1">精华</option>
						<option value="0">普通</option>
				</select></td>
				<td class="input_content" colspan="2">
					<button onclick="javascript:doSubmit('tolist');">查询帖子</button>
					
				</td>
				
			</tr>
		</table>
		<script type="text/javascript">
		myform.jsign.value=${param.jsign};
		</script>
		<!-- 列表数据 -->
		<span style="font-weight: bold;">帖子列表</span>
		<table class="data_table	" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="data_title" style="width: 10%;"
					onclick="order_by('tid');">帖子编号</td>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('title');">帖子标题</td>
					<td class="data_title" style="width: 10%;"
					onclick="order_by('uname');">发帖人</td>
					
				<td class="data_title" style="width: 10%;"
					onclick="order_by('jsign');">状态</td>
				<td class="data_title" style="width: 20%;">操作</td>
				       
			</tr>
		<c:forEach items="${pageBean.dataList}" var="t">
				<tr>
					<td class="data_cell">${t.tid}</td>
					<td class="data_cell">${t.title}</td>
					<td class="data_cell">${t.uname}</td>                        
					<td class="data_cell">${t.jsignStr}</td>
					<td class="data_cell">
						<button class="op_button" type="button"
							onclick="return del(${t.tid});">删帖子</button>
						<button class="op_button"  type="button"
						onclick="return updatejsign(${t.tid});">改状态 </button>
						<button class="op_button"  type="button"
						onclick="location='toUpdate?tid=${t.tid}';return false;">查看内容 </button>
					</td>
					
					
				</tr>
			</c:forEach>

			<tr>
				<td class="data_cell" colspan="5">
					记录总数：${pageBean.totalRowsCount} 当前页：${pageBean.curPageno} /
					${pageBean.totalPageCount} 页 | <a href="javascript:nextPage(1)">首页</a>
					| <a href="javascript:nextPage(${pageBean.curPageno-1})">上一页</a> |
					<a href="javascript:nextPage(${pageBean.curPageno+1})">下一页</a> | <a
					href="javascript:nextPage(${pageBean.totalPageCount})">尾页</a>
				</td>
			</tr>
		</table>
	</form>
<div id="showdiv" style="display: none">
		<table class="input_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="input_title">用户名</td>
				<td class="input_content" id="divname">&nbsp;</td>
				<td class="input_title">密码</td>
				<td class="input_content">******</td>
			</tr>
			<tr>


			</tr>
		</table>
	</div>
	<BODY background="/teacher/admanage/image/25.jpg">
</body>
</html>
