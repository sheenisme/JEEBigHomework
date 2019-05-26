<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>jee 服务系统</title>
	<link rel="stylesheet" href="./css/rform.css" />
	<script language="javascript" type="text/javascript" src="./js/WdatePicker.js"></script>
	<script type="text/javascript" src="js/Check.js">
	</script>
</head>
<body>
	<div class="container">
		<p class="title">jee服务系统</p>
		<div class="box">
				<div id="user">
					<h2>注册页面</h2>
					<form action="${pageContext.request.contextPath}/user/register.action" method="post" name="user" onsubmit="return checkregister()">
						<input type="hidden" name="action" value="CustomRegister">
						<div class="ui register">
						账&nbsp;&nbsp;&nbsp;&nbsp;号:&nbsp;<input id="name" type="text" name="loginname"><br>
						</div>
						<div class="ui register">
						密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input id="password" type="password" name="password"><br>
						</div>
						<div class="ui register">
						确&nbsp;&nbsp;&nbsp;&nbsp;认:&nbsp;<input id="repck" type="password" name="repck"><br>
						</div>
						<div class="ui register">	
						姓&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;<input id="name" type="text" name="name" ><br>
						</div>
						<div class="ui register">	
						性&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;<input id="sex" type="text" name="sex"><br>
						</div>
						<div class="ui register">
						邮&nbsp;&nbsp;&nbsp;&nbsp;箱:&nbsp;<input id="email" type="text" name="email"><br>
						</div>
						<div class="ui register">
						电&nbsp;&nbsp;&nbsp;&nbsp;话:&nbsp;<input id="phone" type="text" name="phone"><br>
						</div>
						<div class="ui register">
						地&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;<input id="address" type="text" name="address"><br>
						</div>
						<div class="ui date">
						出生日期:&nbsp;<input class="Wdate" type="text" name="birthday" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" value="">	
						</div>
						<input type="hidden" name="date" value="<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,19) %>">	
						<input type="hidden" name="point" value="10">
						<div class="ui register">	
						单&nbsp;&nbsp;&nbsp;&nbsp;位:&nbsp;<input id="unit" type="text" name="unit"><br>
						</div>
						<div class="ui register">	
						备&nbsp;&nbsp;&nbsp;&nbsp;注:&nbsp;<input id="remark" type="text" name="remark"><br>
						</div>
						<div class="m">
							<input class="ui register button" type="submit" value="注册">
						</div>
					</form>	
				</div>
				<br>
				<div><pre>jee 服务系统 - 注册账户页面！<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,19) %></pre></div> 
		</div>
	</div>
	<br><br>
	<p class="foot">
		© jee NetClient v1.1.1
		<br>
	</p>
</body>
</html>