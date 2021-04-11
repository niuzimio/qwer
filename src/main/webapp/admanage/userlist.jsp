<%@ page language="java" pageEncoding="GBK"%>
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
	function updateukey(id){
		if(confirm("您确定修改么？")){
			window.location="updateukey?uid="+id;
		}
		return false;
	}
	function updateflag(id){
		if(confirm("您确定修改么？")){
			window.location="updateflag?uid="+id;
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
	<form action="queryAll" name="myform" method="post">
	<!-- 隐藏域  存放当前页号 -->
		<input type="hidden" name="pageNo" value="${param.pageNo}"> <span
			style="font-weight: bold;">查询条件</span>
		<table class="input_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="input_title">用户名</td>
				<td class="input_content">&nbsp; 
				<input name="uname"
					value="${param.uname}" />
				</td>
				<td class="input_title">状态</td>
				<td class="input_content">
					<select name="ukey">
							<option value="-1">全部</option>
							<option value="1">正常</option>
							<option value="0">禁用</option>
							<option value="2">待解封</option>
					</select>
				</td>
				<td class="input_title">权限</td>
				<td class="input_content">
					<select name="flag">
					         <option value="-1">全部</option>
							<option value="1">用户</option>
							<option value="2">帖子管理员</option>
							<option value="3">系统管理员</option>
					</select>
				</td>

				<td class="input_content" colspan="2">
					<button onclick="javascript:doSubmit('toList');">查 询</button>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		myform.ukey.value=${param.ukey};
		myform.flag.value=${param.flag};
		</script>
		<!-- 列表数据 -->
		<span style="font-weight: bold;">单据列表</span>
		<table class="data_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrId');">编号</td>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrName');">用户名</td>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrFlag');">状态</td>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrUkey');">权限</td>
				<td class="data_title" style="width: 20%;">操作</td>
			</tr>
			
			<c:forEach items="${pageBean.dataList}" var="u">
				<tr>
					<td class="data_cell">${u.uid}</td>
					<td class="data_cell">${u.uname}</td>
					<td class="data_cell">${u.ukeyStr}</td>
					<td class="data_cell">${u.flagStr}</td>
					<td class="data_cell">
						<button class="op_button" type="button"
							onclick="return updateukey(${u.uid});">修改状态</button>
						<button class="op_button" type="button"
							onclick="return updateflag(${u.uid});">修改权限</button>
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
				<td class="input_title">角色</td>
				<td class="input_content"><select name="item.usrRole.roleId">
						<option value="0">未指定</option>
						<s:iterator value="#request.roles" id="role">
							<option value="${role.roleid }">${role.rname}</option>
						</s:iterator>
				</select></td>
				<td class="input_title">状态</td>
				<td class="input_content">正常&nbsp;</td>
			</tr>
		</table>
	</div>
    <BODY background="/teacher/admanage/image/25.jpg">
</body>
</html>
