<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>myjee 客户服务系统</title>
	<link rel="stylesheet" href="./css/form.css" />
	<script type="text/javascript" src="js/Check.js">
	</script>
</head>
<body>
	<div class="container">
		<p class="title">myjee 客户服务系统</p>
		<div class="box">
				<div id="login_box">
						<h2>反馈信息页面</h2>
						<form action="FeedbackServlet" method="post" name="form" >
						<input type="hidden" name="action" value="CreateFeedback">
						<div class="ui field">
						您&nbsp;的&nbsp;名&nbsp;字&nbsp;:&nbsp;<input id="name" type="text" name="linkName" value="建议填写"><br>
						</div>
						<div class="ui field">
						您&nbsp;的&nbsp;邮&nbsp;箱&nbsp;:&nbsp;<input id="name" type="text" name="linkEmail" value="建议填写，便于我们联络您。"><br>
						</div>
						<div class="ui field">
						建&nbsp;议&nbsp;主&nbsp;题&nbsp;:&nbsp;<input id="name" type="text" name="theme" value="请认真填写！"><br>
						</div>
						<div class="ui field">	
						建&nbsp;议&nbsp;内&nbsp;容&nbsp;:&nbsp;<input id="name" type="text" name="description" value="请详细填写！"><br>
						</div>
						<div class="m">
							<input class="ui button" type="submit" value="提交">
						</div>
						</form>	
				</div>
				<br>
				<div><pre>myjee 客户服务系统-反馈页面!&nbsp;&nbsp;&nbsp;</pre></div> 
		</div>
	</div>
	<br>
	<p class="foot">
		© jeeNetClient v1.1.1
		<br>
	</p>
</body>
</html>