<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>欢迎来到我的世界</title>
<jsp:include page="../../base/base.jsp"></jsp:include>
<link rel="Stylesheet" type="text/css"
	href="${basePath }/resource/style/login/Index.css" />
<script type="text/javascript"
	src="${basePath }/resource/script/login/Index.js"></script>
<!-- Bootstrap -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">欢迎来到我的世界</a>
			</div>
			<c:choose>
				<c:when test="${empty sessionScope.GLOBAL_SESSION_USER}">
					<div id="navbar" class="navbar-collapse collapse">
						<form id="loginFrom" class="navbar-form navbar-right"
							action="login.html" method="post">
							<div class="form-group">
								<input type="email" placeholder="邮件" name="email"
									class="form-control ValidateEmail">
							</div>
							<div class="form-group">
								<input type="password" placeholder="密码" name="password"
									class="form-control ValidateNull">
							</div>
							<button type="submit" class="btn btn-success">登陆</button>
						</form>
					</div>
				</c:when>
				<c:when test="${not empty sessionScope.GLOBAL_SESSION_USER}">

					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false"><i
								class="glyphicon glyphicon-user"></i> ${sessionScope.GLOBAL_SESSION_USER.useralias } <span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
										设置</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-user"></i>
										个人资料</a></li>
								<li class="divider"></li>
								<li><a href="${basePath }/login/loginOut.html"><i class="glyphicon glyphicon-log-out"></i>
										退出</a></li>
							</ul></li>
					</ul>
				</c:when>
			</c:choose>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<div class="container main">
		<div class="row">

			<div>
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<h1>欢迎来到我的世界!</h1>
					<p>这里是我的一个测试项目的网站，这里可以分享代码片段，可以讨论代码上的一些东西，可以进行交流互动，后台有缓存管理，以及一些的的最新的技术，都分享在这里。</p>
				</div>
				<div class="row">
					<div class="col-xs-6 col-lg-4">
						<h2>代码片段</h2>
						<p>这里展示了一些优秀的代码片段，比如Hibernate的一些基础操作，一些工具类的分享，碎片化得代码的分享，对代码进行精益求精的编写。</p>
						<p>
							<a class="btn btn-default" href="#" role="button">查看更多 »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>论坛</h2>
						<p>这里有着很多的技术大牛，可以对菜鸟们进行分享技术，以及大牛之间的交流互动，菜鸟的福利到啦，赶快来参加吧，热烈欢迎。</p>
						<p>
							<a class="btn btn-default" href="#" role="button"> 查看更多 »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>博客</h2>
						<p>可以撰写自己的心得，或者分享给别人一些技术性指导，更或者把自己的心得和历程记录新下来，赶快来参加吧，热烈欢迎。</p>
						<p>
							<a class="btn btn-default" href="#" role="button">查看更多 »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>上传下载</h2>
						<p>可以对文件进行上传下载，对自己的一些资源文件或者对别人有帮助的文件的上传分享给别人下载，赶快来参加吧，热烈欢迎</p>
						<p>
							<a class="btn btn-default" href="#" role="button">查看更多 »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>文档学习</h2>
						<p>可以进行在线的文档的学习，可以以ppt的形式对文件进行预览学习，自己上传的文档可以进行预览，赶快来参加吧，热烈欢迎。</p>
						<p>
							<a class="btn btn-default" href="#" role="button">查看更多 »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
					<div class="col-xs-6 col-lg-4">
						<h2>对技术的追求</h2>
						<p>这里是对技术的爱好者来看的地方，来灌水玩的人，这里可能不太适合你们，我们是帮助别人学些的，赶快来参加吧，热烈欢迎</p>
						<p>
							<a class="btn btn-default" href="#" role="button">查看更多 »</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->
				</div>
				<!--/row-->
			</div>

		</div>
		<!--/row-->

		<hr>

		<footer>
			<p>© Company 2014</p>
		</footer>

	</div>
</body>
</html>