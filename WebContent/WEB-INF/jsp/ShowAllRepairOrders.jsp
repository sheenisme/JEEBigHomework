<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<title>显示所有的维修记录</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
	</script>
</head>
<body>
	<div class="container">
	<table id="table" class="table table-condensed" align="center">
	<thead>
	<tr class="active">
		<td>维修单号  </td>
		<td>客户ID  </td>
		<td>报修时间  </td>
		<td>联 系 人   </td>
		<td>联系电话  </td>
		<td>维修地址  </td>
		<td>维修时间  </td>
		<td>维修类型  </td>
		<td>问题描述  </td>
		<td>备注信息  </td>
	</tr>
	</thead>
	<c:forEach items="${list}" var="data">
	<tbody>
	<tr class="active">
		<td><c:out value="${data.order_id}"/></td>
		<td><c:out value="${data.custom_id}"/></td>
		<td><c:out value="${data.apply_time}"/></td>
		<td><c:out value="${data.link_name}"/></td>
		<td><c:out value="${data.link_phone}"/></td>
		<td><c:out value="${data.link_address}"/></td>
		<td><c:out value="${data.repair_time}"/></td>
		<td><c:out value="${data.type}"/></td>
		<td><c:out value="${data.description}"/></td>
		<td><c:out value="${data.remark}"/></td>
	</tr>
	</tbody>
	</c:forEach>
	</table>
	</div>
</body>
</html>