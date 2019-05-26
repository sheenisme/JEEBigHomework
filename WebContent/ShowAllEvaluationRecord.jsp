<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<title>显示所有的评价记录</title>
</head>
<body>
	<%@ page import="java.sql.*,java.util.*,weiyi.dao.*,weiyi.dao.vo.*,weiyi.dao.factory.*" %>
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
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
IDAO<EvaluationRecord,Integer> dao=DAOFactory.getEvaluationRecord();
List<EvaluationRecord> list = dao.findAll();
for(int i=0;i<list.size();i++){
	EvaluationRecord vo=list.get(i);
%>
	<tbody>
	<tr class="active">
		<td><%=vo.getEvaluateId() %></td>
		<td><%=vo.getOrderId().toString() %></td>
		<td><%=vo.getUserId() %></td>
		<td><%=vo.getEvaluateDate() %></td>
		<td><%=vo.getStarLevel() %></td>
		<td><%=vo.getContext().toString() %></td>
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