<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>myjee 客户服务系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Check.js">
	</script>
</head>
<body>
<%
Cookie cookies[]=request.getCookies();
String username="";
String password="";
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("USER_COOKIE")){
			username = cookies[i].getValue().split("#")[0];
			password = cookies[i].getValue().split("#")[1];
		}
	}
}
%>
	<div class="container">
		<p class="title">myjee 客户服务系统</p>
		<div class="box">
				<div id="login_box">
						<h2>登录页面</h2>
						<p>
							<font color="red"> 
								<%--显示提示信息 --%>
								<span id="message">${msg}</span>
							</font>
						</p>
						<form action="${pageContext.request.contextPath}/user/login.action" method="post" name="form" onsubmit="return checklogin()">
						<input type="hidden" name="action" value="UserLogin">
						<div class="ui field">		
						账号：<input id="username" type="text" name="username" value="<%=username%>"><br>
						</div>
						<div class="ui field">	
						密码：<input id="password" type="password" name="password"value="<%=password%>"><br>
						</div>
						<div class="ui check">	
						<input id="checkbox" type="checkbox" name="autoLogin" checked="checked" value="save">&nbsp;&nbsp;记&nbsp;住&nbsp;密&nbsp;码&nbsp;<br>
						</div>
						<div class="m">
							<input class="ui button" type="submit" value="登录">
							<a href="UserRegister.jsp"><input class="ui button" type="button"  value="注册"></a>
							<a href="admin.jsp" class="ui button">管理员登录</a>
						</div>
						</form>	
				</div>
				<br>
				<div><pre>myjee 客户服务系统-登录页面!&nbsp;&nbsp;&nbsp;<a href="foundmm.jsp">找回密码</a></pre></div> 
		</div>
	</div>
	<br>
	<p class="foot">
		© jeeNetClient v1.1.1
		<br>
	</p>
</body>
</html>