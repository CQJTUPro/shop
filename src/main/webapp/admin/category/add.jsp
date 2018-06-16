<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</HEAD>

<body>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/adminCategory_addFirst.action" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			style="border: 1px solid #8ba7e3" border="0" class="table">
			<tr>
				<td class="ta_01" align="center" colSpan="4" height="26">
					<div class="alert alert-success">
						<strong>添加一级分类</strong>
					</div>

				</td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
					<h6>一级分类名称</h6>
				</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input type="text" name="cname" value=""
					id="userAction_save_do_logonName" class="form-control" /></td>
			</tr>

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<button type="submit" id="userAction_save_do_submit" value="确定" class="btn btn-outline-success">
						&#30830;&#23450;</button> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置" class="btn btn-outline-danger">&#37325;&#32622;</button> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="btn btn-outline-secondary" type="button" onclick="history.go(-1)" value="返回" /> <span
					id="Label1"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>