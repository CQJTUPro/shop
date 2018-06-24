<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- 弹出层插件 -->
<link href="${pageContext.request.contextPath}/css/popup_layer.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/popup_layer.js"></script>		
<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/order/list.js">
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#7f8fa6" border="0"
			class="table table-hover">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#dcdde1"><strong>商品列表</strong></TD>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1"
							id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #dcdde1">

								<td align="center" width="7%">序号</td>
								<td align="center" width="10%">订单编号</td>
								<td align="center" width="10%">总金额</td>
								<td align="center" width="10%">收货人</td>
								<td align="center" width="10%">收货地址</td>
								<td align="center" width="10%">收货电话</td>
								<td align="center" width="10%">订单状态</td>
								<td width="53%" align="center">订单详情</td>
							</tr>
							<s:iterator var="o" value="pageBean.list" status="status">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"><s:property
											value="#status.count" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#o.oid" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#o.total" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#o.name" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#o.addr" /></td>
									<td style="HEIGHT: 22px" align="center"><s:property value="#o.phone" /></td>
									<td style="HEIGHT: 22px" align="center"><s:if test="#o.state==1">
												未付款
												</s:if> <s:if test="#o.state==2">
											<a
												href="${pageContext.request.contextPath}/adminOrder_updateOrderState.action?oid=<s:property value="#o.oid"/>"><font
												color="blue">发货</font></a>
										</s:if> <s:if test="#o.state==3">
												未确认收货
												</s:if> <s:if test="#o.state==4">
												交易完成
												</s:if></td>
												<!-- onclick="showDetail(<s:property value="#o.oid"/>)" -->
									<td align="center" style="HEIGHT: 22px"><input id="btn<s:property value="#o.oid"/>"
										onclick="findOrderItemByOid(<s:property value="#o.oid"/>)" type="button" value="详细信息" class="clickedElement">
										<div id="div<s:property value="#o.oid"/>"></div></td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td>第<s:property value="pageBean.page" />页/<s:property value="pageBean.totalPage" />&nbsp;&nbsp;&nbsp;&nbsp;
						<s:if test="pageBean.page!=1">
							<a href="${pageContext.request.contextPath}/adminOrder_findAll.action?page=1"
								class="btn btn-outline-success">首页</a>
							<a
								href="${pageContext.request.contextPath}/adminOrder_findAll.action?page=<s:property value="pageBean.page-1"/>"
								class="btn btn-outline-success">上一页</a>
						</s:if> <s:if test="pageBean.page!=pageBean.totalPage">
							<a
								href="${pageContext.request.contextPath}/adminOrder_findAll.action?page=<s:property value="pageBean.page+1"/>"
								class="btn btn-outline-success">下一页</a>
							<a
								href="${pageContext.request.contextPath}/adminOrder_findAll.action?page=<s:property value="pageBean.totalPage"/>"
								class="btn btn-outline-success">尾页</a>
						</s:if>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
	<!-- 弹出层 订单详情  -->
        <div id="showOrderItemDiv" class="blk" style="display:none;">
            <div class="main">
                <h2>订单编号：<span id="shodDivOid" style="font-size: 13px;color: #999">123456789</span></h2>
                <a href="javascript:void(0);" id="closeBtn" class="closeBtn">关闭</a>
                <div id="loading" style="padding-top:30px;text-align: center;">
                	<img alt="" style="width:100px;height:100px;" src="${pageContext.request.contextPath }/images/loading.gif">
                </div>
				<div style="padding:20px;">
					<table id="showDivTab" style="width:100%">
						
					</table>
				</div>
            </div>
            
        </div>
</body>
</HTML>

