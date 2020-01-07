<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>唯e数码  服务系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Check.js">
	</script>
</head>
<body>
	<div class="container">
		<p class="title">唯e数码 服务系统</p>
		<div class="box">
				<div id="login_box">
						<h2>信息页面</h2>
						<h2><font color="red"> 
								<%--显示提示信息 --%>
								<span id="message">${msg}</span>
							</font>
						</h2>
					</div> 
		</div>
	</div>
	<br>
	<br>
	<p class="foot">
		© 唯e数码  NetClient v1.1.1
		<br>
	</p>
</body>
</html>