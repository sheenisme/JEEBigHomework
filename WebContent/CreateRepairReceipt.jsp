<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<title>填写回执单页面</title>
</head>
<body>
<%@ page import="java.sql.*,java.util.*,jee.com.core.po.*" %>
<%
	Admin u=(Admin)request.getSession().getAttribute("ADMIN_SESSION"); 
%>
	<div class="container">
		<form  action="${pageContext.request.contextPath}/admin/createRepairReceipt.action" method="post">
			<div class="form-group">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">请选择维修单号:</label>
				<br>
				<select name="order_id">
					<option value="1">1</option>
				</select>
				<br>
				<input type="hidden" name="admin_id" value="<%=u.getId()%>">
				<input type="hidden" name="repair_time" value="<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,23) %>">
  				<label style="font-size: 18px;font-weight: 50;text-align: center;">是否更换了配件？&nbsp;&nbsp;<input type="checkbox" name="need_parts"></label>
				<br>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">配件类型</label>
				<input class="form-control" type="text" style="width:50%" name="parts_type" value="若未使用，可不填！">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">解决方案：</label>
				<input class="form-control" type="text" style="width:50%" name="resolvent">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">您的建议：</label>
        		<input class="form-control" type="text" style="width:50%" name="advise">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">备注：</label>
				<input class="form-control" type="text" style="width:50%" name="remark">
				<input class="btn btn-primary  active" type="submit" value=" 确认回执  ">
			</div>
		</form>
	</div>
</body>
</html>