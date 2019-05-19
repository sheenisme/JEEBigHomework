function checkname(name){
	var Expression1=/^[a-zA-Z0-9_]{3,10}$/;     //3-10个 字母数字下划线 组成
	var objExp1=new RegExp(Expression1);
	//alert(name.value);
	//alert(objExp1);
	if(objExp1.test(name.value) == true){
		return true;
	}else{
		return false;
	}
}
	
function checkpassword(password){
	var Expression4=/^[A-Za-z]{1}([A-Za-z0-9]|[._]){5,19}$/; //6-20位字母数字下划线和点“.”组成
	var objExp4=new RegExp(Expression4);
	if(objExp4.test(password.value) == true){
		return true;
	}else{
		return false;
	}
}

function checkemail(email){
	var Expression3=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
	var Reg3=new RegExp(Expression3);
	if(Reg3.test(email.value) == false){
		return false;
	}else{
		return true;
	}
}

function checkemail(){
	var email=document.getElementById("email");
	var Expression3=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
	var Reg3=new RegExp(Expression3);
	//alert("开始检查邮箱！");
	if(email.value==""){
		alert("请输入您的邮箱（用于找回密码）！");
		email.focus();
		return false;
	}
	if(Reg3.test(email.value) == false){
		alert("您输入的邮箱格式有误！");
		email.focus();
		return false;
	}else{
		return true;
	}
	return true;
}

function checkregister(){
	var name=document.getElementById("name");
	var password=document.getElementById("password");
	var repck=document.getElementById("repck");
	var email=document.getElementById("email");
	//alert("开始检查！");
	//alert(name.value);
	//alert(password.value);
	if(name.value==""){
		alert("请输入您的账号!");
		name.focus();
		return false;
	}
	if(!checkname(name)){
		alert("您输入的账号不正确！");
		name.focus();
		return false;
	}
	if(password.value==""){
		alert("请输入密码！");
		password.focus();
		return false;
	}
	if(password.value != repck.value){
		alert("两次输入的密码不一致! ");
		password.focus();
		return false;
	}
	if(email==""){
		alert("请输入您的邮箱（用于找回密码）！");
		email.focus();
		return false;
	}
	if(!checkemail(email)){
		alert("您输入的邮箱格式有误！");
		email.focus();
		return false;
	}
	//alert("检查完成");
	return true;
}

function checklogin(){
	var email=document.getElementById("email");
	var name=document.getElementById("name");
	var password=document.getElementById("password");
	//alert("开始检查");
	if(name.value==""){
		alert("请输入您的账号!");
		name.focus();
		return false;
	}
	if(!checkname(name)){
		alert("您输入的账号不正确！");
		name.focus();
		return false;
	}
	if(password.value==""){
		alert("请输入密码！");
		password.focus();
		return false;
	}
	return ture;
}