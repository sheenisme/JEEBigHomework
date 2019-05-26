<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<title>显示所有的评价记录</title>
</head>
<body>
	<div class="container">
	<table id="table" class="table table-condensed" align="center">
	<thead>
	<tr class="active">
		<td> 账户名   </td>
		<td> 名   字   </td>
		<td> 性   别   </td>
		<td> 邮   箱   </td>
		<td> 电   话   </td>
		<td> 地   址   </td>
		<td> 生   日   </td>
		<td>注册日期  </td>
		<td> 积   分   </td>
		<td> 单   位   </td>
		<td> 备   注   </td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="data">
	<tr class="active">
		<td>${data.login_name}</td>
		<td>${data.name}</td>
		<td>${data.sex}</td>
		<td>${data.email}</td>
		<td>${data.phone}</td>
		<td>${data.address}</td>
		<td>${data.birthday}</td>
		<td>${data.date}</td>
		<td>${data.point}</td>
		<td>${data.unit}</td>
		<td>${data.remark}</td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</body>
</html>