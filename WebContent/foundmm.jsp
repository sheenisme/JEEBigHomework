<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>找回密码</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Check.js">
	</script>
</head>
<body>
	<div class="container">
		<p class="title">jee 客户服务系统</p>
		<div class="box">
				<div id="register_box">
						<h2>找回密码页面</h2>
						<!--  不设置为：action="Foundmm" 因为没有邮箱服务器，很难发送邮件  -->
						<form action="" method="post" name="form" onsubmit="return checkemail()">
						<div class="ui foundmm">	
						  邮   箱：    <input id="email" type="text" name="email"><br>
						</div>
						<div class="m">
							<input class="ui register button" type="submit" value="找回">
						</div>
						</form>	
				</div>
				<br>
				<div><pre>Jee服务系统  - 找回密码页面！</pre></div> 
		</div>
	</div>
	<br><br>
	<p class="foot">
		© jee NetClient v1.1.1
		<br>
	</p>
</body>
</html>