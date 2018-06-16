<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#7f8fa6" border="0"
			class="table table-hover">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#dcdde1"><strong>用户列表</strong></TD>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1"
							id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #dcdde1">

								<td align="center" width="10%">序号</td>
								<td align="center" width="15%">账号名称</td>
								<td align="center" width="15%">用户姓名</td>
								<td align="center" width="15%">用户邮箱</td>
								<td align="center" width="15%">用户电话</td>
								<td width="15%" align="center">编辑</td>
								<td width="15%" align="center">删除</td>
							</tr>
							<s:iterator var="u" value="pageBean.list" status="status">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"><s:property
											value="#status.count" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#u.username" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#u.name" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#u.email" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#u.phone" /></td>
									<td align="center" style="HEIGHT: 22px"><a
										href="${pageContext.request.contextPath}/adminUsers_editUserPage.action?uid=<s:property value="#u.uid"/>">
											<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0"
											style="CURSOR: hand">
									</a></td>

									<td align="center" style="HEIGHT: 22px"><a
										href="${pageContext.request.contextPath}/adminUsers_removeUser.action?uid=<s:property value="#u.uid"/>">
											<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16"
											border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td>第<s:property value="pageBean.page" />页/<s:property value="pageBean.totalPage" />&nbsp;&nbsp;&nbsp;&nbsp;
						<s:if test="pageBean.page!=1">

							<a href="${pageContext.request.contextPath}/adminCategory_findSecond.action?page=1"
								class="btn btn-outline-success">首页</a>
							<a
								href="${pageContext.request.contextPath}/adminCategory_findSecond.action?page=<s:property value="pageBean.page-1"/>"
								class="btn btn-outline-success">上一页</a>
						</s:if> <s:if test="pageBean.page!=pageBean.totalPage">
							<a
								href="${pageContext.request.contextPath}/adminCategory_findSecond.action?page=<s:property value="pageBean.page+1"/>"
								class="btn btn-outline-success">下一页</a>
							<a
								href="${pageContext.request.contextPath}/adminCategory_findSecond.action?page=<s:property value="pageBean.totalPage"/>"
								class="btn btn-outline-success">尾页</a>

						</s:if>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

