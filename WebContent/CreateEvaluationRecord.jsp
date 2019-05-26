<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<title>我要进行评价</title>
</head>
<body>
	<%@ page import="java.sql.*,java.util.*,jee.com.core.po.*" %>
	<%
		User u=(User)request.getSession().getAttribute("USER_SESSION"); 
	%>
	<div class="container">
		<form  action="${pageContext.request.contextPath}/user/createEvaluationRecord.action" method="post">
			<div class="form-group">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">请选择您的维修单号</label>
				<br>
				<select name="order_id">
 					<option value="1">1</option> 
				</select>
				<br>
				<input type="hidden" name="user_id" value=<%=u.getId() %>>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">编号是：<%=u.getId() %>&nbsp;&nbsp;的客户，您好！</label>
				<input type="hidden" name="date" value="<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,19) %>">
				<br>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">您认为此次服务的星级是：</label>
				<br>
				<select name="level">
 					<option value="1">1颗星</option> 
 					<option value="2">2颗星</option> 
 					<option value="3">3颗星</option> 
 					<option value="4">4颗星</option> 
 					<option value="5">5颗星</option> 
				</select>
				<br>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">服务详细描述：</label>
				<input class="form-control" type="text" style="width:50%" name="context">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">备注：</label>
				<input class="form-control" type="text" style="width:50%" name="remark">
				<input class="btn btn-primary  active" type="submit" value=" 确认评价！  ">
			</div>
		</form>
	</div>
</body>
</html>