<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<title>显示所有回执信息</title>
</head>
<body>
	<div class="container">
	<table id="table" class="table table-condensed" align="center">
	<thead>
	<tr class="active">
		<td>回执编号</td>
		<td>订单编号  </td>
		<td>管理员编号  </td>
		<td>维修时间 </td>
		<td>是否使用配件   </td>
		<td>配件类型  </td>
		<td>解决方案  </td>
		<td>其他建议  </td>
		<td>备注信息  </td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="data">
	<tr class="active">
		<td><c:out value="${data.receipt_id}"/></td>
		<td><c:out value="${data.order_id}"/></td>
		<td><c:out value="${data.admin_id}"/></td>
		<td><c:out value="${data.repair_time}"/></td>
		<td><c:out value="${data.need_parts}"/></td>
		<td><c:out value="${data.parts_type}"/></td>
		<td><c:out value="${data.resolvent}"/></td>
		<td><c:out value="${data.advise}"/></td>
		<td><c:out value="${data.remark}"/></td>
	</tr>
	</c:forEach>
	</tbody>

	</table>
	</div>
</body>
</html>