<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>管理员首页</title>
<style>
body{
	background:#F5F5F5;
}
#main{
			margin: 30px auto;
			width:100%;
			height:800px;
			
     }
#left{
			margin:4% 0px 2% 1%;
			background:#fff;
			width:220px;
			height:75%;
			float:left;
	  }
#right{
			width:800px;
			height:100%;
			width:80%;
			float:right;
       }
#navigation li{
		width: 187px;
		heighe:200px;
		margin-left:0px;
		float: left;
		list-style-type:none;
	}
	
#navigation a{
		color: #2980b9;
		font-size: 18px;
		font-family: '微软雅黑' '宋体' 'sans-serif';
		text-align: left;
		line-height: 50px;
		display: block;
		width: 187px;
		text-decoration:none;
		}
#foot {
	position: bottom;
	margin: 15px 15px 0;
	font-size: 15px;
	float:right;
}
.container{
	width:100%;
}
</style>
</head>
<body>
<div id="header">
	<div class="container">	
		<ul class="nav nav-tabs nav-justified" >
			<li class="active"><a href="#">我的主页</a></li>
			<li ><a href="http://www.sheensong.top/wordpress">论坛</a></li>
			<li ><a href="${pageContext.request.contextPath}/Feedback.jsp">反馈</a></li>
			<%@ page import="java.sql.*,java.util.*,jee.com.core.po.*" %>
			<%
				Admin u=(Admin)request.getSession().getAttribute("ADMIN_SESSION"); 
			%> 
			<li class="disabled" ><a><%=u.getLogin_name() %>管理员</a></li>
			<li ><a href="${pageContext.request.contextPath}/admin/logout.action">退出登录</a></li>		
		</ul>
		
	</div>

</div>

<div id="main">
	<div id="left" class="container">
		<ul id="navigation">
			<!-- CreateRepairReceipt.jsp -->
			<li><a href="${pageContext.request.contextPath}/admin/preCreateRepairReceipt.action" target="rightFrame">维&nbsp;修&nbsp;回&nbsp;执&nbsp;单</a></li>
			<li><a href="${pageContext.request.contextPath}/CreatePcParts.jsp" target="rightFrame">录入配件信息</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/showAllRepairReceipt.action" target="rightFrame">查看回执信息</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/showAllRepairOrders.action" target="rightFrame">查看维修信息</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/showAllEvaluationRecord.action" target="rightFrame">查看评价信息</a></Li>
			<li><a href="${pageContext.request.contextPath}/admin/showAllFeedback.action" target="rightFrame">查看反馈信息</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/showAllPcParts.action" target="rightFrame">查看配件信息</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/showAllUser.action" target="rightFrame">查看所有客户</a></li>
			<li><a href="${pageContext.request.contextPath}/message.jsp" target="rightFrame">查看统计信息</a></li>
			<li><a href="${pageContext.request.contextPath}/RevisePcParts.jsp" target="rightFrame">修改配件信息</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/preReviseAdmin.action?id=<%=u.getId() %>" target="rightFrame">修改个人信息</a></li>
			<li><a href="${pageContext.request.contextPath}/adminreg.jsp" target="rightFrame">申请下级管理员</a></li>
		</ul>
	</div>
	<div id="right" class="container">
		<iframe width="100%"  height="100%"  name="rightFrame"></iframe>
	</div>
</div>


<div id="foot" align="center" class="container">
	<p align="center"> 
		© jee NetClient v1.1.1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统当前时间为：<%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,19) %>
	<br>
	</p>
</div>
</body>
</html>