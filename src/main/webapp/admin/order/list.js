function showDetail(oid) {
	var divo = document.getElementById("div" + oid);
	var btn = document.getElementById("btn"+oid);
	if (btn.value == "详细信息") {
		//创建异步对象
		var xhr=createXmlHttp();
		//设置监听
		xhr.onreadystatechange=function(){
		if(xhr.readyState==4)
		  if(xhr.status==200){					  
		        divo.innerHTML=xhr.responseText;
		  }
		};
		//打开链接
		xhr.open("GET","${pageContext.request.contextPath}/adminOrder_findOrderItemByOid.action?oid="+oid+"&time="+new Date().getTime(),true);
		//发送
		xhr.send(null);
		btn.value = "关闭";
	} else {
		divo.innerHTML = "";
		btn.value = "详细信息";
	}
}
function createXmlHttp() {
	var xmlHttp;
	try { // Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {// Internet Explorer
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}

	return xmlHttp;
}