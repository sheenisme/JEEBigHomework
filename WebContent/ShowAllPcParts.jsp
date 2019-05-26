<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<title>显示所有配件的基本信息</title>
</head>
<body>
	<%@ page import="java.sql.*,java.util.*,weiyi.dao.*,weiyi.dao.vo.*,weiyi.dao.factory.*" %>
	<div class="container">
	<table id="table" class="table table-condensed" align="center">
	<thead>
	<tr class="active">
		<td> 序   号   </td>
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
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
IDAO<PcParts,Integer> dao=DAOFactory.getPcParts();
List<PcParts> list = dao.findAll();
for(int i=0;i<list.size();i++){
	PcParts vo=list.get(i);
%>
	<tbody>
	<tr class="active">
		<td><%=i+1 %></td>
		<td><%=vo.getId() %></td>
		<td><%=vo.getName().toString() %></td>
		<td><%=vo.getType().toString() %></td>
		<td><%=vo.getProducer().toString() %></td>
		<td><%=vo.getTotal() %></td>
		<td><%=vo.getRemainder() %></td>
		<td><%=vo.getPrice() %></td>
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