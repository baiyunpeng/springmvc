<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">

<title>欢迎登陆</title>
<jsp:include page="../../base/base.jsp"></jsp:include>
<script type="text/javascript" src="${basePath }resource/script/user/register/register.js"></script>
</head>

<body>

	<div class="container">
		<form id="registerForm" class="form-signin form-horizontal" action="register.html" method="post" >
			<div class="col-md-6 col-md-offset-2">
				<h2 class="form-signin-heading">欢迎注册</h2>
				<div class="form-group">
					<label for="username" class="col-sm-4 control-label">账号：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</div>
							<input type="text" class="form-control" id="username"
								name="username" placeholder="账号">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="useralias" class="col-sm-4 control-label">姓名：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</div>
							<input type="text" class="form-control" id="useralias"
								name="useralias" placeholder="姓名">
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="sex" class="col-sm-4 control-label">性别：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</div>
							<select class="form-control" id="sex" name="sex">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="col-sm-4 control-label">密码：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</div>
							<input type="password" class="form-control" id="password"
								name="password" placeholder="密码">
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="confirmPassword" class="col-sm-4 control-label">重复密码：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</div>
							<input type="password" class="form-control" id="confirmPassword"
								name="confirmPassword" placeholder="重复密码">
						</div>
					</div>
				</div>


				<div class="form-group">
					<label for="cardid" class="col-sm-4 control-label">身份证号码：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-credit-card"></i>
							</div>
							<input type="text" class="form-control" id="cardid" name="cardid"
								placeholder="身份证号码">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">电子邮件：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-envelope"></i>
							</div>
							<input type="email" class="form-control" id="inputEmail3"
								name="email" placeholder="Email">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="phone" class="col-sm-4 control-label">电话号码：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-phone"></i>
							</div>
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="电话号码">
						</div>
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="birthdate" class="col-sm-4 control-label">出生日期：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-calendar"></i>
							</div>
							<input type="text" readonly="readonly" class="form-control currentDate" id="birthdate" name="birthdate" onclick="WdatePicker()"
								placeholder="出生日期">
						</div>
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="address" class="col-sm-4 control-label">家庭住址：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-home"></i>
							</div>
							<input type="text" class="form-control" id="address"
								name="address" placeholder="家庭住址">
						</div>
					</div>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
			</div>
		</form>
	</div>
</body>
</html>