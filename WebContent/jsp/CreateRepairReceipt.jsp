<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script language="javascript" type="text/javascript" src="./js/WdatePicker.js"></script>
<title>填写回执单页面</title>
</head>
<body>
<%@ page import="java.sql.*,java.util.*,com.jee.dao.*,com.jee.dao.vo.*,com.jee.dao.factory.*" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	Cookie cookies[]=request.getCookies();
	int id=0;
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("AdminCookie")){
				id=Integer.parseInt(cookies[i].getValue().split("#")[2]);
			}
		}
	}
%>
	<div class="container">
		<form  action="AdminServlet" method="post">
			<div class="form-group">
				<input type="hidden" name="action" value="CreateRepairReceipt"> 
				
				<br>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">请选择维修单号:</label>
				<select name="orderId">
				<%
				Cookie Customcookies[]=request.getCookies();
				String userId="";
				int customid=0;
				if(cookies!=null){
					for(int i=0;i<cookies.length;i++){
						if(cookies[i].getName().equals("CustomCookie")){
							userId = cookies[i].getValue().split("#")[2];
							customid=Integer.parseInt(userId);
						}
					}
				}
				IRepairOrdersDAO dao=DAOFactory.getRepairOrders();
				List<String> list = dao.findOrderId(customid);
				for(int i=0;i<list.size();i++){
					String vo=list.get(i);
				%>
					<option value="<%=vo.toString() %>"><%=vo.toString() %></option>
				<%
				}
				%>
				</select>
				<br>
				
				<input type="hidden" name="adminId" value="<%=id%>">
				<input type="hidden" name="repairTime" value="<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,23) %>">
  				<label style="font-size: 18px;font-weight: 50;text-align: center;">是否更换了配件？&nbsp;&nbsp;<input type="checkbox" name="needParts"></label>
				<br>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">配件类型</label>
				<input class="form-control" type="text" style="width:50%" name="partsType" value="若未使用，可不填！">
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