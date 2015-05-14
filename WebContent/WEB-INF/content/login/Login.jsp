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
<jsp:include page="../base/base.jsp"></jsp:include>
</head>

<body>

	<div class="container">
		<form class="form-signin form-horizontal">
			<div class="col-md-4 col-md-offset-4">
				<h2 class="form-signin-heading">欢迎登陆</h2>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">电子邮件：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-envelope"></i>
							</div>
							<input type="email" class="form-control" id="inputEmail3"
								placeholder="Email">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">密码：</label>
					<div class="col-sm-8">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="glyphicon glyphicon-lock"></i>
							</div>
							<input type="password" class="form-control" id="inputEmail3"
								placeholder="password">
						</div>
					</div>
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
			</div>
		</form>
	</div>



</body>
</html>