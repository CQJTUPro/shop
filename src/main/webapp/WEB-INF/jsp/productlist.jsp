<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>网上商城</title>
	<link href="./css/common.css" rel="stylesheet" type="text/css" />
	<link href="./css/product.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container header">

		<%@ include file="menu.jsp"%>

	</div>
	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory" id="categoryDiv">
				<%-- <s:iterator value="#session.clist" var="c">
					<s:if test="#c.parentid==0">
						<dl>
							<dt>
								<a
									href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="#c.cid"/>&page=1">
									<s:property value="#c.cname" />
								</a>
							</dt>
							<s:iterator value="#session.clist" var="cs">
								<s:if test="#cs.parentid==#c.cid">
									<dd>
										<a
											href="${pageContext.request.contextPath}/product_findByCidPage.action?cid=<s:property value="#cs.cid"/>&page=1"><s:property
												value="#cs.cname" /></a>
									</dd>
								</s:if>
							</s:iterator>
						</dl>
					</s:if>
				</s:iterator> --%>
			</div>
		</div>
		<script type="text/javascript">
	//header.jsp加载完毕后 去服务器端获得所有的category数据
	$(function(){
		var content = "";
		$.post(
			"${pageContext.request.contextPath}/category_findAllCategory.action",
			function(data){
				//[{"cid":"xxx","cname":"xxxx"},{},{}]
				//动态创建菜单与子菜单
				for(var i=0;i<data.length;i++){
					if(data[i].parentid==0){
					  content+="<dl><dt><a href='${pageContext.request.contextPath}/product_findByParentidPage.action?parentid="+data[i].cid+
							  "&page=1' >"+data[i].cname+"</a></dt>";
					for(var j=0;j<data.length;j++){
						   if (data[j].parentid==data[i].cid){
					          content+="<dd><a href='${pageContext.request.contextPath}/product_findByCidPage.action?cid="+data[j].cid+
					         "&page=1' >"+data[j].cname+"</a></dd>";
						 }
					   }
					}	
					content+="</dl>";
				}			
				//将拼接好的li放置到ul中
				$("#categoryDiv").html(content); 
			},
			"json"
		);
	});
	</script>
		<div class="span18 last">

			<form id="productForm" action="./image/蔬菜 - Powered By Mango Team.htm" method="get">

				<div id="result" class="result table clearfix">
					<ul>
						<s:iterator value="pageBean.list" var="p">
							<li><a
								href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>">
									<img src="${pageContext.request.contextPath}/<s:property value="#p.image" />" width="170"
									height="170" style="display: inline-block;"><span style='color: green'> <s:property
												value="#p.pname" />
									</span> <span class="price"> 商城价： ￥<s:property value="#p.shop_price" />/份
									</span>
							</a></li>
						</s:iterator>
					</ul>
				</div>
				<div class="pagination">
					<s:if test="parentid!=null">
						<span>第<s:property value="pageBean.page" />/<s:property value="pageBean.totalPage" />页
							(<s:property value="pageBean.totalCount" />条)
						</span>
						<s:if test="pageBean.page!=1">
							<a class="firstPage"
								href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="parentid"/>&page=1">&nbsp;</a>
							<a class="previousPage"
								href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="parentid"/>&page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
						</s:if>

						<s:iterator var="i" begin="1" end="pageBean.totalPage">
							<s:if test="#i==pageBean.page">
								<a class="currentPage"
									href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="parentid"/>&page=<s:property value="#i"/>"><s:property
										value="#i" /></a>
							</s:if>
							<s:else>
								<a
									href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="parentid"/>&page=<s:property value="#i"/>"><s:property
										value="#i" /></a>
							</s:else>

						</s:iterator>
						<s:if test="pageBean.totalPage!=pageBean.page">
							<a class="nextPage"
								href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="parentid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
							<a class="lastPage"
								href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="parentid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
						</s:if>
					</s:if>


					<s:if test="cid!=null">
						<span>第<s:property value="pageBean.page" />/<s:property value="pageBean.totalPage" />页
							(<s:property value="pageBean.totalCount" />条)
						</span>
						<s:if test="pageBean.page!=1">
							<a class="firstPage"
								href="${pageContext.request.contextPath}/product_findByCidPage.action?cid=<s:property value="cid"/>&page=1">&nbsp;</a>
							<a class="previousPage"
								href="${pageContext.request.contextPath}/product_findByCidPage.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
						</s:if>

						<s:iterator var="i" begin="1" end="pageBean.totalPage">
							<s:if test="#i==pageBean.page">
								<a class="currentPage"
									href="${pageContext.request.contextPath}/product_findByCidPage.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property
										value="#i" /></a>
								<%-- <a class="currentPage"
									href="javascript:void(0);"><s:property
										value="#i" /></a> --%>
							</s:if>
							<s:else>
								<a
									href="${pageContext.request.contextPath}/product_findByCidPage.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property
										value="#i" /></a>
							</s:else>

						</s:iterator>
						<s:if test="pageBean.totalPage!=pageBean.page">
							<a class="nextPage"
								href="${pageContext.request.contextPath}/product_findByCidPage.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
							<a class="lastPage"
								href="${pageContext.request.contextPath}/product_findByCidPage.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
						</s:if>
					</s:if>
				</div>
			</form>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="./image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>诚聘英才</a> |</li>
				<li><a>法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>官网</a> |</li>
				<li><a>论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>