<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set scope="request" var="basePath">${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/</c:set>
<c:set scope="request" var="resourcePath">${basePath }resource/</c:set>
<link rel="Stylesheet" type="text/css" href="${basePath }/resource/style/global.css" />
<link rel="Stylesheet" type="text/css" href="${basePath }/resource/bootshap/css/bootstrap.css" />
<script type="text/javascript" src="${basePath }/resource/script/jquery/jquery-1.11.2.js"></script>
<script type="text/javascript" src="${basePath }/resource/bootshap/js/bootstrap.js"></script>
<!-- 图片轮播插件 -->
<script type="text/javascript" src="${basePath }/resource/script/jquery/unslider.js"></script>
<!-- bootshap验证框架插件 -->
<link rel="Stylesheet" type="text/css" href="${basePath }/resource/script/jquery/validate/css/bootstrapValidator.css" />
<script type="text/javascript" src="${basePath }/resource/script/jquery/validate/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${basePath }/resource/script/jquery/validate/js/language/zh_CN.js"></script>

<!-- MyDate97 -->
<script type="text/javascript" src="${basePath }/resource/script/jquery/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="${basePath }/resource/script/jquery/Date.js"></script>
<script type="text/javascript" src="${basePath }/resource/script/jquery/common.js"></script>