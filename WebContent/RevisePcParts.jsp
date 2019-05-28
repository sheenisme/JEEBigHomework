<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>jee 客户服务系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<form action="${pageContext.request.contextPath}/admin/revisePcParts.action" method="post" name="registerform">
			<div class="form-group">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">配件编号</label>
				<input class="form-control" type="text" style="width:50%" name="id" value="<c:out value="${vo.id}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">配件名字</label>
				<input class="form-control" type="text" style="width:50%" name="name" value="<c:out value="${vo.name}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">配件类型</label>
				<input class="form-control" type="text" style="width:50%" name="type" value="<c:out value="${vo.type}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">生产商</label>
				<input class="form-control" type="text" style="width:50%" name="producer" value="<c:out value="${vo.producer}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">总量</label>
				<input class="form-control" type="text" style="width:50%" name="total" value="<c:out value="${vo.total}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">余量</label>
				<input class="form-control" type="text" style="width:50%" name="remainder" value="<c:out value="${vo.remainder}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">进价</label>
				<input class="form-control" type="text" style="width:50%" name="bid" value="<c:out value="${vo.bid}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">售价</label>
 	       		<input class="form-control" type="text" style="width:50%" name="price" value="<c:out value="${vo.price}"/>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">备注：</label>
				<input class="form-control" type="text" style="width:50%" name="remark" value="<c:out value="${vo.remark}"/>">
				<input class="btn btn-primary  active" type="submit" value=" 确认修改  ">
		</div>
	</form>	
</div>
</body>
</html>