<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>myjee 客户服务系统</title>
	<link rel="stylesheet" href="./css/rform.css" />
	<script language="javascript" type="text/javascript" src="./js/WdatePicker.js"></script>
	<script type="text/javascript" src="js/Check.js">
	</script>
</head>
<body>
<%@ page import="java.sql.*,java.util.*,com.jee.dao.*,com.jee.dao.vo.*,com.jee.dao.factory.*" %>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	Cookie cookies[]=request.getCookies();
	IDAO<Admin,Integer> dao=DAOFactory.getAdmin();
	Admin vo=null;
	int id;
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("AdminCookie")){
				id=Integer.parseInt(cookies[i].getValue().split("#")[2]);
				vo=dao.findById(id);
			}
		}
	}
%>
	<div class="container">
		<p class="title">myjee 客户服务系统</p>
		<div class="box">
				<div id="register_box">
					<h2>修改管理员信息页面</h2>
					<form action="AdminServlet" method="post" name="registerform" onsubmit="return checkregister()">
						<input type="hidden" name="action" value="AdminUpdate">
						<input type="hidden" name="id" value="<%=vo.getId() %>">
						<div class="ui register">
						账&nbsp;&nbsp;&nbsp;&nbsp;号:&nbsp;<input id="name" type="text" name="loginName" value="<%=vo.getLoginName() %>"><br>
						</div>
						<div class="ui register">
						密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input id="password" type="password" name="password" ><br>
						</div>
						<div class="ui register">
						确&nbsp;&nbsp;&nbsp;&nbsp;认:&nbsp;<input id="repck" type="password" name="repck" ><br>
						</div>
						<div class="ui register">	
						姓&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;<input id="name2" type="text" name="name" value="<%=vo.getName() %>"><br>
						</div>
						<div class="ui register">	
						性&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;<input id="sex" type="text" name="sex" value="<%=vo.getSex() %>"><br>
						</div>
						<div class="ui register">
						邮&nbsp;&nbsp;&nbsp;&nbsp;箱:&nbsp;<input id="email" type="text" name="email" value="<%=vo.getEmail() %>"><br>
						</div>
						<div class="ui register">
						电&nbsp;&nbsp;&nbsp;&nbsp;话:&nbsp;<input id="phone" type="text" name="phone" value="<%=vo.getPhone() %>"><br>
						</div>
						<div class="ui register">
						地&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;<input id="address" type="text" name="address" value="<%=vo.getAddress() %>"><br>
						</div>
						<input type="hidden" name="date" value="<%=vo.getDate() %>">	
						<input type="hidden" name="grade" value="<%=vo.getGrade() %>">
						<input type="hidden" name="upperId"value="<%=vo.getUpperId() %>">
						<div class="ui register">	
						备&nbsp;&nbsp;&nbsp;&nbsp;注:&nbsp;<input id="remark" type="text" name="remark"value="<%=vo.getRemark() %>"><br>
						</div>
						<div class="m">
							<input class="ui register button" type="submit" value="确认修改">
						</div>
					</form>	
				</div>
				<br>
				<div><pre>myjee 客户服务系统 - 修改管理员信息页面！</pre></div> 
		</div>
	</div>
	<br><br>
	<p class="foot">
		© jeeNetClient v1.1.1
		<br>
	</p>
</body>
</html>