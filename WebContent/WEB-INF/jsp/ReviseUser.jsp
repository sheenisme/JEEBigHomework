<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>唯e数码  服务系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/rform.css" />
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Check.js">
	</script>
</head>
<body>
	<div class="container">
		<p class="title">唯e数码  服务系统</p>
		<div class="box">
				<div id="register_box">
					<h2>修改客户信息页面</h2>
					<form action="${pageContext.request.contextPath}/user/reviseUser.action" method="post" name="registerform" onsubmit="return checkregister()">
						<input type="hidden" name="id" value="<c:out value="${vo.id}"/>">
						<div class="ui register">
						账&nbsp;&nbsp;&nbsp;&nbsp;号:&nbsp;<input id="name" type="text" name="login_name" value="<c:out value="${vo.login_name}"/>"><br>
						</div>
						<div class="ui register">
						密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input id="password" type="password" name="password" ><br>
						</div>
						<div class="ui register">
						确&nbsp;&nbsp;&nbsp;&nbsp;认:&nbsp;<input id="repck" type="password" name="repck" ><br>
						</div>
						<div class="ui register">	
						姓&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;<input id="name" type="text" name="name" value="<c:out value="${vo.name}"/>"><br>
						</div>
						<div class="ui register">	
						性&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;<input id="sex" type="text" name="sex" value="<c:out value="${vo.sex}"/>"><br>
						</div>
						<div class="ui register">
						邮&nbsp;&nbsp;&nbsp;&nbsp;箱:&nbsp;<input id="email" type="text" name="email" value="<c:out value="${vo.email}"/>"><br>
						</div>
						<div class="ui register">
						电&nbsp;&nbsp;&nbsp;&nbsp;话:&nbsp;<input id="phone" type="text" name="phone" value="<c:out value="${vo.phone}"/>"><br>
						</div>
						<div class="ui register">
						地&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;<input id="address" type="text" name="address" value="<c:out value="${vo.address}"/>"><br>
						</div>
						<div class="ui date">
						出生日期:&nbsp;<input class="Wdate" type="text" name="birthday" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})" value="<c:out value="${vo.birthday}"/>">	
						</div>
						<input type="hidden" name="date" value="<c:out value="${vo.date}"/>">	
						<input type="hidden" name="point" value="<c:out value="${vo.point}"/>">
						<div class="ui register">	
						单&nbsp;&nbsp;&nbsp;&nbsp;位:&nbsp;<input id="unit" type="text" name="unit" value="<c:out value="${vo.unit}"/>"><br>
						</div>
						<div class="ui register">	
						备&nbsp;&nbsp;&nbsp;&nbsp;注:&nbsp;<input id="remark" type="text" name="remark" value="<c:out value="${vo.remark}"/>"><br>
						</div>
						<div class="m">
							<input class="ui register button" type="submit" value="确认修改">
						</div>
					</form>	
				</div>
				<br>
				<div>
					<pre>唯e数码  服务系统 - 修改客户信息页面！</pre>
				</div> 
		</div>
	</div>
	<br><br>
	<p class="foot">
		© 唯e数码  NetClient v1.1.1
		<br>
	</p>
</body>
</html>