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
		<td>评价编号  </td>
		<td> 订单号   </td>
		<td>客户编号  </td>
		<td>评价时间  </td>
		<td>服务星级  </td>
		<td>评价内容  </td>
		<td>备注信息  </td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="data">
	<tr class="active">
		<td><c:out value="${data.evaluate_id}"/></td>
		<td><c:out value="${data.order_id}"/></td>
		<td><c:out value="${data.user_id}"/></td>
		<td><c:out value="${data.date}"/></td>
		<td><c:out value="${data.level}"/></td>
		<td><c:out value="${data.context}"/></td>
		<td><c:out value="${data.remark}"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</body>
</html>