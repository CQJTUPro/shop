<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

body, td, th {
	color: #000000;
}
-->
</style>
<style>
BODY {
	SCROLLBAR-FACE-COLOR: #cccccc;
	SCROLLBAR-HIGHLIGHT-COLOR: #ffffFF;
	SCROLLBAR-SHADOW-COLOR: #ffffff;
	SCROLLBAR-3DLIGHT-COLOR: #cccccc;
	SCROLLBAR-ARROW-COLOR: #ffffff;
	SCROLLBAR-TRACK-COLOR: #ffffFF;
	SCROLLBAR-DARKSHADOW-COLOR: #cccccc;
}
</style>
</head>

<body>

	<form name="Form1" method="post" action="name.aspx" id="Form1">

		<table width="100%" border="0" height="88" border="1"
			background="${pageContext.request.contextPath}/images/back1.JPG">


			<tr>
				<td width="65%" height="84" align="center" valign="top">
					<div class="alert alert-success">
						<s:if test="#session.adminUser!=null">
							<strong>登录成功!</strong> 欢迎进入后台管理系统。</s:if>
					</div>
				</td>
			</tr>
			<tr>
				<td height=2></td>
			</tr>

		</table>

	</form>

</body>

</html>