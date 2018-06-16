<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	type="text/css">
</HEAD>

<body>
	<form id="userAction_save_do" enctype="multipart/form-data" name="Form1"
		action="${pageContext.request.contextPath}/adminProduct_addProduct.action" method="post">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee"
			style="border: 1px solid #8ba7e3" border="0" class="table">
			<tr>
				<td class="ta_01" align="center" colSpan="4" height="26">
					<div class="alert alert-success">
						<strong>添加商品</strong>
					</div>

				</td>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="pname" value=""
					id="userAction_save_do_logonName" class="form-control" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">所属分类：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="category.cid" class="form-control">
						<s:iterator value="clist" var="c">
							<option value="<s:property value="#c.cid"/>"><s:property value="#c.cname" /></option>
						</s:iterator>
				</select></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">商品市场价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="market_price" value=""
					id="userAction_save_do_logonName" class="form-control" /></td>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">商品商城价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text" name="shop_price" value=""
					id="userAction_save_do_logonName" class="form-control" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">是否热门：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="is_hot" class="form-control">
						<option value="1">是</option>
						<option value="0">否</option>
				</select></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe">商品图片：</td>
				<td class="ta_01" bgColor="#ffffff"><input name="upload" type="file" /></td>
			</tr>
			<tr>
				<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">商品描述：</td>
				<td class="ta_01" bgColor="#ffffff"><textarea rows="5" cols="30" name="pdesc"
						class="form-control"></textarea></td>
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