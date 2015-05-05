<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>欢迎来到我的世界</title>
<jsp:include page="base.jsp"></jsp:include>
<!-- Bootstrap -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
.banner {
	position: relative;
	overflow: auto;
}

.banner li {
	list-style: none;
}

.banner ul li {
	float: left;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">我的世界</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#"><i
							class="glyphicon glyphicon-home"></i> 首页</a></li>
					<li><a href="#">提问</a></li>
					<li><a href="#">社区</a></li>
					<li><a href="#">论坛</a></li>
					<li><a href="#">工具</a></li>
					<li><a href="#">下载</a></li>
					<li><a href="#">关于</a></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="glyphicon glyphicon-tasks"></i> <span class="badge">42</span>
							<span class="caret"></span> </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"> 软件更新
									<div class="progress">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="20" aria-valuemin="0"
											aria-valuemax="100" style="width: 20%">
											<span class="sr-only">20% Complete</span>
										</div>
									</div>

							</a></li>
							<li><a href="#"> 硬件更新
									<div class="progress">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
											style="width: 20%">
											<span class="sr-only">20% Complete</span>
										</div>
									</div>
							</a></li>
							<li class="divider"></li>
							<li><a href="#"> 单元测试
									<div class="progress">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="20" aria-valuemin="0"
											aria-valuemax="100" style="width: 20%">
											<span class="sr-only">20% Complete</span>
										</div>
									</div>
							</a></li>
							<li><a href="#"> 错误修复
									<div class="progress">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="20" aria-valuemin="0"
											aria-valuemax="100" style="width: 20%">
											<span class="sr-only">20% Complete</span>
										</div>
									</div>
							</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="glyphicon glyphicon-bell"></i> <span class="badge">42</span>
							<span class="caret"></span> </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><i
									class="glyphicon glyphicon-warning-sign"></i> 通知 </a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
									新闻评论 </a></li>
							<li class="divider"></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-shopping-cart"></i> 新订单 </a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>
									粉丝 </a></li>
						</ul></li>


					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="glyphicon glyphicon-envelope"></i> <span class="badge">42</span>
							<span class="caret"></span> </a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">消息 </a></li>
							<li><a href="#"> 硬件更新 </a></li>
							<li class="divider"></li>
							<li><a href="#"> 单元测试 </a></li>
							<li><a href="#"> 错误修复 </a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="glyphicon glyphicon-user"></i> 个人中心 <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
									设置</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>
									个人资料</a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="glyphicon glyphicon-log-out"></i>
									退出</a></li>
						</ul></li>
				</ul>
			</div>
			
		</div>
		
	</nav>

	<div class="container">
		<div class="row">
			<div class="sidebar col-sm-4 col-md-2">
				<ul class="navigation">
					<li class="active menu"><a href="#"><i class="glyphicon glyphicon-scale"></i> 控制台 <span
							class="sr-only">(current)</span></a></li>
					<li class="menu"><a href="#"><i class="glyphicon glyphicon-hdd"></i>缓存管理</a></li>
					<li class="menu"><a href="#">组件</a></li>
					<li class="menu"><a href="#">表格</a></li>
					<li class="menu"><a href="#">表单</a></li>
				</ul>
				<ul class="navigation">
					<li class="menu"><a href="">Nav item</a></li>
					<li class="menu"><a href="">Nav item again</a></li>
					<li class="menu"><a href="">One more nav</a></li>
					<li class="menu"><a href="">Another nav item</a></li>
					<li class="menu"><a href="">More navigation</a></li>
				</ul>
				<ul class="navigation">
					<li class="menu"><a href="">Nav item again</a></li>
					<li class="menu"><a href="">One more nav</a></li>
					<li class="menu"><a href="">Another nav item</a></li>
				</ul>
			</div>
			<div class=".col-sm-8 main">
				<h2 class="sub-header">Section title</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Header</th>
								<th>Header</th>
								<th>Header</th>
								<th>Header</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1,001</td>
								<td>Lorem</td>
								<td>ipsum</td>
								<td>dolor</td>
								<td>sit</td>
							</tr>
							<tr>
								<td>1,002</td>
								<td>amet</td>
								<td>consectetur</td>
								<td>adipiscing</td>
								<td>elit</td>
							</tr>
							<tr>
								<td>1,003</td>
								<td>Integer</td>
								<td>nec</td>
								<td>odio</td>
								<td>Praesent</td>
							</tr>
							<tr>
								<td>1,003</td>
								<td>libero</td>
								<td>Sed</td>
								<td>cursus</td>
								<td>ante</td>
							</tr>
							<tr>
								<td>1,004</td>
								<td>dapibus</td>
								<td>diam</td>
								<td>Sed</td>
								<td>nisi</td>
							</tr>
							<tr>
								<td>1,005</td>
								<td>Nulla</td>
								<td>quis</td>
								<td>sem</td>
								<td>at</td>
							</tr>
							<tr>
								<td>1,006</td>
								<td>nibh</td>
								<td>elementum</td>
								<td>imperdiet</td>
								<td>Duis</td>
							</tr>
							<tr>
								<td>1,007</td>
								<td>sagittis</td>
								<td>ipsum</td>
								<td>Praesent</td>
								<td>mauris</td>
							</tr>
							<tr>
								<td>1,008</td>
								<td>Fusce</td>
								<td>nec</td>
								<td>tellus</td>
								<td>sed</td>
							</tr>
							<tr>
								<td>1,009</td>
								<td>augue</td>
								<td>semper</td>
								<td>porta</td>
								<td>Mauris</td>
							</tr>
							<tr>
								<td>1,010</td>
								<td>massa</td>
								<td>Vestibulum</td>
								<td>lacinia</td>
								<td>arcu</td>
							</tr>
							<tr>
								<td>1,011</td>
								<td>eget</td>
								<td>nulla</td>
								<td>Class</td>
								<td>aptent</td>
							</tr>
							<tr>
								<td>1,012</td>
								<td>taciti</td>
								<td>sociosqu</td>
								<td>ad</td>
								<td>litora</td>
							</tr>
							<tr>
								<td>1,013</td>
								<td>torquent</td>
								<td>per</td>
								<td>conubia</td>
								<td>nostra</td>
							</tr>
							<tr>
								<td>1,014</td>
								<td>per</td>
								<td>inceptos</td>
								<td>himenaeos</td>
								<td>Curabitur</td>
							</tr>
							<tr>
								<td>1,015</td>
								<td>sodales</td>
								<td>ligula</td>
								<td>in</td>
								<td>libero</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>