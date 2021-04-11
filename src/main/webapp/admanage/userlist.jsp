<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="path.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>�û�����</title>
<link rel="stylesheet" type="text/css" href="admanage/css/styles.css">
<link rel="stylesheet" type="text/css"
	href="admanage/js/jquery-ui-1.8.4.custom.css">
<script src="admanage/js/jquery.1.4.2.js"></script>
<script type="text/javascript"
	src="admanage/js/jquery-ui-1.8.4.custom.min.js"></script>
<script type="text/javascript" src="admanage/js/jquery-ui-i18n.js"></script>
<script type="text/javascript">
	function updateukey(id){
		if(confirm("��ȷ���޸�ô��")){
			window.location="updateukey?uid="+id;
		}
		return false;
	}
	function updateflag(id){
		if(confirm("��ȷ���޸�ô��")){
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
	<!-- ������  ��ŵ�ǰҳ�� -->
		<input type="hidden" name="pageNo" value="${param.pageNo}"> <span
			style="font-weight: bold;">��ѯ����</span>
		<table class="input_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="input_title">�û���</td>
				<td class="input_content">&nbsp; 
				<input name="uname"
					value="${param.uname}" />
				</td>
				<td class="input_title">״̬</td>
				<td class="input_content">
					<select name="ukey">
							<option value="-1">ȫ��</option>
							<option value="1">����</option>
							<option value="0">����</option>
							<option value="2">�����</option>
					</select>
				</td>
				<td class="input_title">Ȩ��</td>
				<td class="input_content">
					<select name="flag">
					         <option value="-1">ȫ��</option>
							<option value="1">�û�</option>
							<option value="2">���ӹ���Ա</option>
							<option value="3">ϵͳ����Ա</option>
					</select>
				</td>

				<td class="input_content" colspan="2">
					<button onclick="javascript:doSubmit('toList');">�� ѯ</button>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		myform.ukey.value=${param.ukey};
		myform.flag.value=${param.flag};
		</script>
		<!-- �б����� -->
		<span style="font-weight: bold;">�����б�</span>
		<table class="data_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrId');">���</td>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrName');">�û���</td>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrFlag');">״̬</td>
				<td class="data_title" style="width: 20%;"
					onclick="order_by('usrUkey');">Ȩ��</td>
				<td class="data_title" style="width: 20%;">����</td>
			</tr>
			
			<c:forEach items="${pageBean.dataList}" var="u">
				<tr>
					<td class="data_cell">${u.uid}</td>
					<td class="data_cell">${u.uname}</td>
					<td class="data_cell">${u.ukeyStr}</td>
					<td class="data_cell">${u.flagStr}</td>
					<td class="data_cell">
						<button class="op_button" type="button"
							onclick="return updateukey(${u.uid});">�޸�״̬</button>
						<button class="op_button" type="button"
							onclick="return updateflag(${u.uid});">�޸�Ȩ��</button>
					</td>
				</tr>
			</c:forEach>

			<tr>
				<td class="data_cell" colspan="5">
					��¼������${pageBean.totalRowsCount} ��ǰҳ��${pageBean.curPageno} /
					${pageBean.totalPageCount} ҳ | <a href="javascript:nextPage(1)">��ҳ</a>
					| <a href="javascript:nextPage(${pageBean.curPageno-1})">��һҳ</a> |
					<a href="javascript:nextPage(${pageBean.curPageno+1})">��һҳ</a> | <a
					href="javascript:nextPage(${pageBean.totalPageCount})">βҳ</a>
				</td>
			</tr>
		</table>
	</form>

	<div id="showdiv" style="display: none">
		<table class="input_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<td class="input_title">�û���</td>
				<td class="input_content" id="divname">&nbsp;</td>
				<td class="input_title">����</td>
				<td class="input_content">******</td>
			</tr>
			<tr>
				<td class="input_title">��ɫ</td>
				<td class="input_content"><select name="item.usrRole.roleId">
						<option value="0">δָ��</option>
						<s:iterator value="#request.roles" id="role">
							<option value="${role.roleid }">${role.rname}</option>
						</s:iterator>
				</select></td>
				<td class="input_title">״̬</td>
				<td class="input_content">����&nbsp;</td>
			</tr>
		</table>
	</div>
    <BODY background="/teacher/admanage/image/25.jpg">
</body>
</html>
