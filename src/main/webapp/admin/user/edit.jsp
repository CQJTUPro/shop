<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
		action="${pageContext.request.contextPath}/adminUsers_editUser.action" method="post">
		&nbsp; <input type="hidden" name="uid" value="<s:property value="model.uid"/>" /> <input
			type="hidden" name="state" value="<s:property value="model.state"/>" /> <input type="hidden"
			name="code" value="<s:property value="model.code"/>" />
		<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee"
			style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="6" height="26"><strong><STRONG>编辑用户</STRONG>
				</strong></td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">账号名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="username"
					value="<s:property value="model.username" />" class="form-control" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">用户姓名：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="name"
					value="<s:property value="model.name" />" class="form-control" /></td>

			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">用户密码：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="password" name="password"
					value="<s:property value="model.password" />" class="form-control" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">邮箱：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="email"
					value="<s:property value="model.email" />" class="form-control" /></td>

			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">电话：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="phone"
					value="<s:property value="model.phone" />" class="form-control" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">地址：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="addr"
					value="<s:property value="model.addr" />" class="form-control" /></td>
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