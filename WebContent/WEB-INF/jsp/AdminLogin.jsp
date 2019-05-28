<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Jee 服务系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Check.js">
	</script>
</head>
<body>
<%
Cookie cookies[]=request.getCookies();
String name="";
String password="";
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("ADMIN_COOKIE")){
			name = cookies[i].getValue().split("#")[0];
			password = cookies[i].getValue().split("#")[1];
			//System.out.println("AdminCookie中的名字和密码是："+name+"  "+password);
		}
	}
}
%>
	<div class="container">
		<p class="title">jee 服务系统</p>
		<div class="box">
			<div id="login_box">
			<h2>管理员登录页面</h2>
			<p>
				<font color="red"> 
				<%--显示提示信息 --%>
					<span id="message">${msg}</span>
				</font>
			</p>
			<form action="${pageContext.request.contextPath}/admin/login.action" method="post" name="form" onsubmit="return checklogin()">
				<input type="hidden" name="action" value="AdminLogin">
				<div class="ui field">		
				账号：<input id="loginname" type="text" name="login_name" value="<%=name %>"><br>
				</div>
				<div class="ui field">	
				密码：<input id="password" type="password" name="password" value="<%=password %>"><br>
				</div>
				<div class="ui check">	
					<input id="checkbox" type="checkbox" checked="checked" name="autoLogin" value="save">&nbsp;记&nbsp;住&nbsp;密&nbsp;码&nbsp;<br>
				</div>
				<div class="m">
					<input class="ui button" type="submit" value="登录">
				</div>
			</form>	
			</div>
			<br>
			<div>
				<pre>jee 服务系统-管理员登录页面!    <a href="${pageContext.request.contextPath}/foundmm.jsp">找回密码</a></pre>
			</div> 
		</div>
	</div>
	<br>
	<br>
	<p class="foot">
		© jee NetClient v1.1.1
		<br>
	</p>
</body>
</html>