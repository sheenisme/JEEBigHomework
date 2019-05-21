<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script language="javascript" type="text/javascript" src="./js/WdatePicker.js"></script>
<title>我要进行评价</title>
</head>
<body>
	<%@ page import="java.sql.*,java.util.*,com.jee.dao.*,com.jee.dao.vo.*,com.jee.dao.factory.*" %>
	<%
Cookie cookies[]=request.getCookies();
String userId="";
int id=0;
String name="";
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("CustomCookie")){
			name = cookies[i].getValue().split("#")[0];
			userId = cookies[i].getValue().split("#")[2];
			id=Integer.parseInt(userId);
		}
	}
}
%>
	<div class="container">
		<form  action="CustomServlet" method="post">
			<div class="form-group">
				<input type="hidden" name="action" value="CreateEvaluationRecord"> 
				<br>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">请选择您的维修单号</label>
				<select name="orderId">
				<%
				IRepairReceiptDAO dao=DAOFactory.getRepairReceipt();
				List<String> list = dao.findOrderId(id);
				for(int i=0;i<list.size();i++){
					String vo=list.get(i);
				%>
					<option value="<%=vo.toString() %>"><%=vo.toString() %></option>
				<%
				}
				%>
				</select>
				<br>
				<input type="hidden" name="userId" value=<%=userId %>>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">编号是：<%=userId %>&nbsp;&nbsp;的客户，您好！</label>
				<br>
				<input type="hidden" name="evaluateDate" value="<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,19) %>">
				
				<label style="font-size: 18px;font-weight: 50;text-align: center;">服务的星级</label>
				<input class="form-control" type="text" style="width:50%" name="starLevel">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">服务详细描述：</label>
				<input class="form-control" type="text" style="width:50%" name="Context">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">备注：</label>
				<input class="form-control" type="text" style="width:50%" name="remark">
				<input class="btn btn-primary  active" type="submit" value=" 确认评价！  ">
			</div>
		</form>
	</div>
</body>
</html>