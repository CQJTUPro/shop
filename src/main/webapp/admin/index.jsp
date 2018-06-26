<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<title>网上商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css">

	<style type="text/css">
body {
	background-image:
		url(${pageContext.request.contextPath}/image/adminloginbrd.jpg);
	background-size: cover;
}
</style>
<script type="text/javascript">
window.onload=function(){
	if(window.parent!=window){
		window.parent.location.href="${pageContext.request.contextPath}/admin/index.jsp";
	}
}
</script>
	<body>
		<center>
			<div class="alert alert-danger">
				<s:property value="#request.info" />
		</center>
		<form method="post" action="${pageContext.request.contextPath }/adminUser_login.action"
			target="_parent" name='theForm' onsubmit="return validate()">
			<div class="container">

				<div class="form-group">
					<span class="badge badge-success"><h5>管理员姓名</h5></span> <input class="form-control" type="text"
						name="username" />
				</div>
				<div class="form-group">
					<span class="badge badge-success"><h5>管理员密码：</h5></span> <input class="form-control"
						type="password" name="password" />
				</div>
				<div>
					&nbsp; <input type="submit" class="btn btn-primary btn-lg btn-block" value="进入管理中心" />
				</div>



			</div>
			<input type="hidden" name="act" value="signin" />
		</form>

	</body>