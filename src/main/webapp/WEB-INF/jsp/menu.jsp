<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="span5">
	<div class="logo">
		<!--  <a href="http://localhost:8080/mango/"> <img
			src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客"></a>
	-->
	</div>
</div>
<div class="span9">
	<div class="headerAd">
		<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障"
			title="正品保障">
	</div>
</div>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<s:if test="#session.user==null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;"><a
					href="${pageContext.request.contextPath}/user_loginPage.action">登录</a>|</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;"><a
					href="${pageContext.request.contextPath}/user_registPage.action">注册</a>|</li>
			</s:if>
			<s:else>
				<li style="color: blue;">欢迎您，<s:property value="#session.user.username" />&nbsp;
				</li>
				<li id="headerMyOrder" class="headerRegister" style="display: list-item;"><a
					href="${pageContext.request.contextPath}/order_findByUid.action?page=1">我的订单</a>|
				<li id="quit" class="headerRegister" style="display: list-item;"><a
					href="${pageContext.request.contextPath}/user_quit.action">退出</a>|
			</s:else>
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${pageContext.request.contextPath}/cart_cartPage.action">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24" align="center">
	<form>
		<div class="form-group style=" position:relative" id="showDivParent">
			<input name="pname" id="search" type="text" onfocus="searchWord(this)" onkeyup="searchWord(this)"
				class="form-control" style="width: 400px; height: 30px" />
			<button type="submit" class="btn btn-primary">搜索</button>
			<div id="showDiv" align="left"
				style="position: absolute; left: 33%; background: #fff; width: 403px; border: 1px solid #ccc;">
			</div>
		</div>
	</form>
	<!-- 完成异步搜索 -->
	<script type="text/javascript">
	    $(function(){
	    	//点击showDivParent以外的区域隐藏showDiv
	    	$(document).bind("click",function(e){
	    		var target  = $(e.target);
	    		if(target.closest("#showDivParent").length == 0){
	    			$("#showDiv").css("display", "none");
	    		}
	    	})
	    });
		function overFn(obj) {
			$(obj).css("background", "#DBEAF9");
		}
		function outFn(obj) {
			$(obj).css("background", "#fff");
		}

		function clickFn(obj) {
			$("#search").val($(obj).html());
			$("#showDiv").css("display", "none");
		}

		function searchWord(obj) {
			//1、获得输入框的输入的内容
			var word = $(obj).val();
			//2、根据输入框的内容去数据库中模糊查询---List<Product>
			var content = "";
			$.post(
				"${pageContext.request.contextPath}/product_findProductNameByWord.action",
				{"word" : word},
				function(data) {
				   //3、将返回的商品的名称 现在showDiv中
				   //[{"pid":"1","pname":"小米 4c 官方版","market_price":8999.0,"shop_price":8999.0,"pimage":"products/1/c_0033.jpg","pdate":"2016-08-14","is_hot":1,"pdesc":"小米 4c 标准版 全网通 白色 移动联通电信4G手机 双卡双待 官方好好","pflag":0,"cid":"1"}]
                   if (data.length > 0) {
						for (var i = 0; i < data.length; i++) {
							content += "<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)'>"
									+ data[i] + "</div>";
						}
						$("#showDiv").html(content);
						$("#showDiv").css("display", "block");
				   }

		        }
				, "json");

		}
	</script>
</div>

<div class="span24" style="margin-top: 20px;">
	<ul class="mainNav" id="categoryUl">
		<li><a href="${pageContext.request.contextPath}/index.action">首页</a> |</li>
		<%-- <s:iterator value="#session.clist" var="c">
			<s:if test="#c.parentid==0">
				<li><a
					href="${pageContext.request.contextPath}/product_findByParentidPage.action?parentid=<s:property value="#c.cid"/>&page=1"><s:property
							value="#c.cname" /></a> |</li>
			</s:if>
		</s:iterator> --%>
	</ul>
</div>
<script type="text/javascript">
	//menu.jsp加载完毕后 去服务器端获得所有的category数据
	$(function(){
		var content = "<li><a href='${pageContext.request.contextPath}/index.action'>首页</a> |</li>";
		$.post(
			"${pageContext.request.contextPath}/category_findAllCategory.action",
			function(data){
				//[{"cid":"xxx","cname":"xxxx"},{},{}]
				//动态创建<li><a href="#">${category.cname }</a></li>
				for(var i=0;i<data.length;i++){
					if(data[i].parentid==0){
					  content+="<li><a href='${pageContext.request.contextPath}/product_findByParentidPage.action?parentid="+data[i].cid+"&page=1'>"+data[i].cname+"</a>|</li>";
					}
				}			
				//将拼接好的li放置到ul中
				$("#categoryUl").html(content);
			},
			"json"
		);
	});
	</script>