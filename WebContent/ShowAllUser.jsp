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
		<td> 编  号    </td>
		<td> 账户名   </td>
		<td> 名   字   </td>
		<td> 性   别   </td>
		<td> 邮   箱   </td>
		<td> 电   话   </td>
		<td> 地   址   </td>
		<td> 生   日   </td>
		<td>注册日期  </td>
		<td> 积   分   </td>
		<td> 单   位   </td>
		<td> 备   注   </td>
	</tr>
	</thead>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
IDAO<Custom,Integer> dao=DAOFactory.getCustom();
List<Custom> list = dao.findAll();
for(int i=0;i<list.size();i++){
	Custom vo=list.get(i);
%>
	<tbody>
	<tr class="active">
		<td><%=vo.getId() %></td>
		<td><%=vo.getLoginName().toString() %></td>
		<td><%=vo.getName().toString()%></td>
		<td><%=vo.getSex().toString() %></td>
		<td><%=vo.getEmail().toString() %></td>
		<td><%=vo.getPhone().toString()%></td>
		<td><%=vo.getAddress().toString() %></td>
		<td><%=vo.getBirthday() %></td>
		<td><%=vo.getDate() %></td>
		<td><%=vo.getPoint().toString()%></td>
		<td><%=vo.getUnit().toString() %></td>
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