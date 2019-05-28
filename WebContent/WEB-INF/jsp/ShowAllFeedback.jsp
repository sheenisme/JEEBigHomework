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
		<td>反馈编号  </td>
		<td>反馈者姓名   </td>
		<td>反馈者邮箱  </td>
		<td>反馈主题  </td>
		<td>详细内容  </td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="data">
	<tr class="active">
		<td><c:out value="${data.id}"/></td>
		<td><c:out value="${data.name}"/></td>
		<td><c:out value="${data.email}"/></td>
		<td><c:out value="${data.theme}"/></td>
		<td><c:out value="${data.description}"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</body>
</html>