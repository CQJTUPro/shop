<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>

	<div class="container cart">

		<div class="span24">

			<div class="step step1" style="width: 100%;" align="center">
				<ul>

					<li class="current"></li>
					<s:if test="model.state==1">
						<li>订单未付款</li>
					</s:if>
					<s:if test="model.state==2">
						<li>已付款，等待发货</li>
					</s:if>
					<s:if test="model.state==3">
						<li>已发货&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath}/order_updateState.action?oid=<s:property value="nodel.oid" />"><font
								color="blue">确认收货</font></a></li>
					</s:if>
					<s:if test="model.state==4">
						<li>交易完成</li>
					</s:if>
				</ul>
			</div>


			<table>
				<tbody>
					<tr>
						<th colspan="5">订单编号：<s:property value="model.oid" /></th>
					</tr>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<s:iterator value="model.orderItems" var="orderItem">
						<tr>
							<td width="60"><a
								href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#orderItem.product.pid"/>">
									<img
									src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>" />
							</a></td>
							<td><a
								href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#orderItem.product.pid"/>"><s:property
										value="#orderItem.product.pname" /></a></td>
							<td><s:property value="#orderItem.product.shop_price" /></td>
							<td><s:property value="#orderItem.count" /></td>
							<td width="140"><span class="subtotal">￥<s:property value="#orderItem.subtotal" /></span></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<dl id="giftItems" class="hidden" style="display: none;">
			</dl>
			<div class="total">
				<em id="promotion"></em> 商品金额: <strong id="effectivePrice">￥<s:property
						value="model.total" />元
				</strong>
			</div>
			<s:if test="model.state==1">
				<form id="orderForm" action="${pageContext.request.contextPath}/order_payOrder.action"
					method="post">
					<input type="hidden" name="oid" value="<s:property value="model.oid" />" />
					<div class="span24">
						<p>
							收货地址：<input name="addr" type="text" value="<s:property value="model.addr" />"
								style="width: 350px" /> <br /> 收货人&nbsp;&nbsp;&nbsp;： <input name="name" type="text"
								value="<s:property value="model.name" />" style="width: 150px" /> <br /> 联系方式：<input
								name="phone" type="text" value="<s:property value="model.phone" />" style="width: 150px" />
						</p>
						<hr />
						<p>
							选择银行：<br /> <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked" />
							工商银行<img src="${pageContext.request.contextPath}/bank_img/icbc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="BOC-NET-B2C" /> 中国银行 <img
								src="${pageContext.request.contextPath}/bank_img/bc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="ABC-NET-B2C" /> 农业银行 <img
								src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle" /> <br /> <input
								type="radio" name="pd_FrpId" value="BOCO-NET-B2C" /> 交通银行 <img
								src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="PINGANBANK-NET" /> 平安银行 <img
								src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CCB-NET-B2C" /> 建设银行 <img
								src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle" /> <br /> <input
								type="radio" name="pd_FrpId" value="CEB-NET-B2C" /> 光大银行 <img
								src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C" /> 招商银行 <img
								src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle" />
						</p>
						<hr />
						<p style="text-align: right">
							<a href="javascript:document.getElementById('orderForm').submit();"> <img
								src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51"
								border="0" />
							</a>
						</p>
					</div>
				</form>
			</s:if>
		</div>

	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52"
					width="950">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>SHOP++官网</a> |</li>
				<li><a>SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>