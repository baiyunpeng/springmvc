$(function() {
	$("#username").keypress(function(event) {
		var key_code = event.keyCode;
		if (key_code == 13) {
			var username = $(this).val();
			if(isEmpty(username)){
				$("#username").focus();
				tips("#username","用户名或邮箱不能为空");
			}else{
				$("#password").focus();
			}
		}
	});
	

	$("#password").keypress(function(event) {
		var key_code = event.keyCode;
		if (key_code == 13) {
			var password = $(this).val();
			if(isEmpty(password)){
				tips("#password","密码不能为空");
			}else{
				checklogin();
			}
			
		}
	});
	
	$("#loginButton").click(function(){
		
		checklogin();
	});
	
	function validate(){
		var username = $("#username").val();
		if(isEmpty(username)){
			$("#username").focus();
			tips("#username","用户名或邮箱不能为空");
			throw "用户名或邮箱不能为空";
		}
		
		var password = $("#password").val();
		if(isEmpty(password)){
			$("#password").focus();
			tips("#password","密码不能为空");
			throw "密码不能为空";
		}
	}
	
	function checklogin(){
		validate();
		var username = $("#username").val();
		var password = $("#password").val();
		var index = loading();
		$.post("checkLogin.html", { "username":encodeURI(username),"password":password },function(data){
			closeLayer(index);
			if(data==-1){
				hintLayer("用户名或密码错误");
			}else if(data==0){
				login();
			}else if(data==1){
				hintLayer("用户已被冻结");
			}else if(data==2){
				hintLayer("用户已被锁定");
			}
		});
	}
	
	
	function login(){
		$("#login").submit();
	}
});