<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<title>显示所有回执信息</title>
</head>
<body>
	<%@ page import="java.sql.*,java.util.*,weiyi.dao.*,weiyi.dao.vo.*,weiyi.dao.factory.*" %>
	<div class="container">
	<table id="table" class="table table-condensed" align="center">
	<thead>
	<tr class="active">
		<td> 序   号   </td>
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
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
IDAO<RepairReceipt,Integer> dao=DAOFactory.getRepairReceipt();
List<RepairReceipt> list = dao.findAll();
for(int i=0;i<list.size();i++){
	RepairReceipt vo=list.get(i);
%>
	<tbody>
	<tr class="active">
		<td><%=i+1 %></td>
		<td><%=vo.getReceiptId() %></td>
		<td><%=vo.getOrderId().toString() %></td>
		<td><%=vo.getAdminId() %></td>
		<td><%=vo.getRepairTime() %></td>
		<td><%=vo.getNeedParts() %></td>
		<td><%=vo.getPartsType().toString() %></td>
		<td><%=vo.getResolvent().toString() %></td>
		<td><%=vo.getAdvise().toString() %></td>
		<td><%=vo.getRemark().toString() %></td>
	</tr>
	</tbody>
<% 
}
%>
	</table>
	</div>
</body>
</html>