<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TD {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TH {
	FONT-SIZE: 12px;
	COLOR: #000000
}
</style>
<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css">
</HEAD>
<body>
	<table width="100%" height="70%" border="0" cellspacing="0" cellpadding="0">
		<tr>

			<td width="100%" background="${pageContext.request.contextPath}/images/top_100.jpg"></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" valign="bottom" background="${pageContext.request.contextPath}/images/mis_01.jpg">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="85%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font color="#40739e">
								<strong><script language="JavaScript">
								<!--
									tmpDate = new Date();
									date = tmpDate.getDate();
									month = tmpDate.getMonth() + 1;
									year = tmpDate.getYear();
									document.write(year);
									document.write("年");
									document.write(month);
									document.write("月");
									document.write(date);
									document.write("日 ");

									myArray = new Array(6);
									myArray[0] = "星期日"
									myArray[1] = "星期一"
									myArray[2] = "星期二"
									myArray[3] = "星期三"
									myArray[4] = "星期四"
									myArray[5] = "星期五"
									myArray[6] = "星期六"
									weekday = tmpDate.getDay();
									if (weekday == 0 | weekday == 6) {
										document.write(myArray[weekday])
									} else {
										document.write(myArray[weekday])
									};
								// -->
								</script> </strong>
						</font>
						</td>
						<td width="15%">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>

									<td width="200" valign="bottom" height="30"
										background="${pageContext.request.contextPath}/images/mis_01.jpg"><s:if
											test="#session.adminUser!=null">
											<p class="font-weight-bold" style="margin-top: 10px;">
												用户名：
												<s:property value="#session.adminUser.username" />
												<a href="${pageContext.request.contextPath}/adminUser_quit.action"
													style="color: red; margin-left: 10px;" target="_parent">退出</a>
											</p>
										</s:if></td>

									</td>
									<td align="right" width="5%"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
</body>
</HTML>
