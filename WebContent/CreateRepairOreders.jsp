<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script language="javascript" type="text/javascript" src="./js/WdatePicker.js"></script>
<title>我要报修</title>
</head>
<body>
	<%@ page import="java.sql.*,java.util.*,com.jee.dao.*,com.jee.dao.vo.*,com.jee.dao.factory.*" %>
	<%
Cookie cookies[]=request.getCookies();
String loginId="";
int id=0;
String name="";
if(cookies!=null){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("CustomCookie")){
			name = cookies[i].getValue().split("#")[0];
			loginId = cookies[i].getValue().split("#")[2];
			id=Integer.parseInt(loginId);
		}
	}
}
%>
	<div class="container">
		<form  action="CustomServlet" method="post">
			<div class="form-group">
				<input type="hidden" name="action" value="CreateRepairOrders"> 
				<input type="hidden" name="customId" value=<%=loginId %>>
				<label style="font-size: 18px;font-weight: 50;text-align: center;">编号是：<%=loginId %>&nbsp;&nbsp;的客户，您好！</label>
				<br>
				<input type="hidden" name="applyTime" value="<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,23) %>">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">联系人：</label>
				<input class="form-control" type="text" style="width:50%" name="linkName">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">联系电话：</label>
				<input class="form-control" type="text" style="width:50%" name="linkPhone">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">维修地址：</label>
				<input class="form-control" type="text" style="width:50%" name="linkAddress">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">维修时间：</label>
        		<input class="form-control Wdate" type="text" style="color: #0000AA;width:30%;height:2.3em" name="repairTime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="请选择您希望的维修员服务时间！">				
				<label style="font-size: 18px;font-weight: 50;text-align: center;">故障类型：</label>
				<input class="form-control" type="text" style="width:50%" name="type">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">问题详细描述：</label>
				<input class="form-control" type="text" style="width:50%" name="description">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">备注：</label>
				<input class="form-control" type="text" style="width:50%" name="remark">
				<input class="btn btn-primary  active" type="submit" value=" 确认报修  ">
			</div>
		</form>
	</div>
</body>
</html>