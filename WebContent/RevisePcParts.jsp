<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>唯 e 客户服务系统</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css" />
</head>
<body>
<%@ page import="java.sql.*,java.util.*,weiyi.dao.*,weiyi.dao.vo.*,weiyi.dao.factory.*" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	Cookie cookies[]=request.getCookies();
	IPcPartsDAO dao=DAOFactory.getPcParts();
	List<PcParts> list=new ArrayList<PcParts>(); 
	PcParts vo=null;
	String name=null;
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("PcPartsCookie")){
				name=cookies[i].getValue().split("#")[0];
				list=dao.findByName(name);
				for(int j=0;j<list.size();j++){
					vo=list.get(j);
%>
					<form action="AdminServlet" method="post" name="registerform">
						<input type="hidden" name="action" value="PcPartsUpdate">
						<div class="form-group">
							<input type="hidden" name="action" value="CreatePcParts"> 
							<label style="font-size: 18px;font-weight: 50;text-align: center;">配件编号</label>
							<input class="form-control" type="text" style="width:50%" name="Id" value="<%=vo.getId() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">配件名字</label>
							<input class="form-control" type="text" style="width:50%" name="name" value="<%=vo.getName() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">配件类型</label>
							<input class="form-control" type="text" style="width:50%" name="type" value="<%=vo.getType() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">生产商</label>
							<input class="form-control" type="text" style="width:50%" name="producer" value="<%=vo.getProducer() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">总量</label>
							<input class="form-control" type="text" style="width:50%" name="total" value="<%=vo.getTotal() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">余量</label>
							<input class="form-control" type="text" style="width:50%" name="remainder" value="<%=vo.getRemainder() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">进价</label>
							<input class="form-control" type="text" style="width:50%" name="bid" value="<%=vo.getBid() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">售价</label>
 				       		<input class="form-control" type="text" style="width:50%" name="price" value="<%=vo.getPrice() %>">
							<label style="font-size: 18px;font-weight: 50;text-align: center;">备注：</label>
							<input class="form-control" type="text" style="width:50%" name="remark" value="<%=vo.getRemark() %>">
							<input class="btn btn-primary  active" type="submit" value=" 确认修改  ">
					</div>
				</form>	
<%
				}
			}
		}
	}
%>
</body>
</html>