<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<title>显示所有配件的基本信息</title>
</head>
<body>
	<div class="container">
	<table id="table" class="table table-condensed" align="center">
	<thead>
	<tr class="active">
		<td>配件编号  </td>
		<td>配件名字  </td>
		<td>配件类型  </td>
		<td> 生厂商   </td>
		<td>配件总量  </td>
		<td>配件余量  </td>
		<td>配件售价  </td>
		<td>备注信息  </td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="data">
	<tr class="active">
		<td><c:out value="${data.id}"/></td>
		<td><c:out value="${data.name}"/></td>
		<td><c:out value="${data.type}"/></td>
		<td><c:out value="${data.producer}"/></td>
		<td><c:out value="${data.total}"/></td>
		<td><c:out value="${data.remainder}"/></td>
		<td><c:out value="${data.price}"/></td>
		<td><c:out value="${data.remark}"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</body>
</html>