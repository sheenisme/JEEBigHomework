<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script language="javascript" type="text/javascript" src="./js/WdatePicker.js"></script>
<title>录入配件信息页面</title>
</head>
<body>
	<div class="container">
		<form  action="AdminServlet" method="post">
			<div class="form-group">
				<input type="hidden" name="action" value="CreatePcParts"> 
				<label style="font-size: 18px;font-weight: 50;text-align: center;">配件名字</label>
				<input class="form-control" type="text" style="width:50%" name="name">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">配件类型</label>
				<input class="form-control" type="text" style="width:50%" name="type">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">生产商</label>
				<input class="form-control" type="text" style="width:50%" name="producer">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">总量</label>
				<input class="form-control" type="text" style="width:50%" name="total">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">余量</label>
				<input class="form-control" type="text" style="width:50%" name="remainder">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">进价</label>
				<input class="form-control" type="text" style="width:50%" name="bid">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">售价</label>
        		<input class="form-control" type="text" style="width:50%" name="price">
				<label style="font-size: 18px;font-weight: 50;text-align: center;">备注：</label>
				<input class="form-control" type="text" style="width:50%" name="remark">
				<input class="btn btn-primary  active" type="submit" value=" 确认录入  ">
			</div>
		</form>
	</div>
</body>
</html>