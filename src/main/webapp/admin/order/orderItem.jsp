<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<table width="100%">
	<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #fff">

		<td align="center" width="15%">图片</td>
		<td align="center" width="55%">商品名称</td>
		<td align="center" width="10%">商品数量</td>
		<td align="center" width="15%">小计</td>
	</tr>
	<s:iterator value="oilist" var="oi">
		<tr>
			<td align="center"><img alt="商品图片" width="40" height="45"
				src="${pageContext.request.contextPath}/<s:property value="#oi.product.image" />"></td>
			<td align="center"><s:property value="#oi.product.pname" /></td>
			<td align="center"><s:property value="#oi.count" /></td>
			<td align="center"><s:property value="#oi.subtotal" /></td>
		</tr>
	</s:iterator>
</table>