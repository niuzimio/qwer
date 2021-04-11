<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="admanage/css/styles.css" />
 <link href="admanage/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="admanage/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(":button").click(function() {
			var uname = $("[name=username]").val();
			var upass = $("[name=password]").val();
			//发送ajax请求
			$.getJSON("login1", {
				uname : uname,
				password : upass
			}, function(jsondata) {
				//alert(jsondata);
				if (jsondata ==-1) {
					alert("用户名或密码错误")
				}
				else if (jsondata ==0) { 
	            	alert("用户名或密码错误")
				}
				else if (jsondata ==1) { 
	            	alert("您的权限不够")
				}
	            else if(jsondata==2) {
					//跳转到成功页面
					window.location = "admanage2/";
				}if(jsondata==3){window.location = "admanage/";}
			});
		});
	});
</script>
</head>
<body>
<%-- <h1> 后台管理系统 </h1>
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
	</div> --%>
	
	<div class="login_box">
      <div class="login_l_img"><img src="img/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="img/login_logo.png" /></a></div>
          <div class="login_name">
               <p>学习论坛交流管理系统</p>
          </div>
          
        
           <form action="login1" method="post">
              <input name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
<input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <input value="登录" type="button">
          </form>
      </div>

</body>
</html>

