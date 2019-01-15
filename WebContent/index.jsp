<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">

/* 
 * HttpURLConnection请求webservice
 */
	$(function(){
		
		$("#btn2").click(function(){
			var name = document.getElementById("name").value;
			$.post(
				"HttpURLConnectionServlet",
				"name="+name,
				function(msg) {
					//alert(msg);
					var $Result = $(msg);
					var value = $Result.find("return").text();
					alert(value);
				},
				"xml"
			);
		});
		
		/*
		 * Jquery请求webservice 
		 */
		$("#btn").click(function(){ //回调函数
			var name = document.getElementById("name").value;
			var data = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><ns2:sayHello xmlns:ns2="http://ws.day01_ws.atguigu.com/"><arg0>'+name+'</arg0></ns2:sayHello></soap:Body></soap:Envelope>';
			//alert(data);
			/* $.post(
				"http://192.168.10.165:8888/day01_ws/datatypews",
				data,
				function(msg){
					alert("------");
					var $Result = $(msg);
					var value = $Result.find("return").text();
					alert(value);
				},
				"xml"
			); */
			
			$.ajax({
				type : "post",
				url : "http://localhost:7777/day01_ws/datatypews",
				data : data,
				success : function(msg){
					alert("------");
					var $Result = $(msg);
					var value = $Result.find("return").text();
					alert(value);
				},
				error : function(msg) {
					//alert("-----"+msg);
				},
				dataType : "xml"
			});
		});
	});
	

	/* 
	 * AJax请求webservice 
	 */
	
	 function reqWebService() {
		var name = document.getElementById("name").value;
		var data = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Body><ns2:sayHello xmlns:ns2="http://ws.day01_ws.atguigu.com/"><arg0>'+name+'</arg0></ns2:sayHello></soap:Body></soap:Envelope>';
		//XMLHttpRequest对象
		var request = getRequest();
		request.onreadystatechange = function(){
			if(request.readyState==4 && request.status==200) {
				var result = request.responseXML;
				alert(result);
				var returnEle = result.getElementsByTagName("return")[0];
				var value = returnEle.firstChild.data;
				alert(value);
			}
		};
		
		request.open("POST", "http://localhost:7777/day01_ws/datatypews");
		
		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		request.send(data);
	}
/**
 * 获取Ajax对象，因为历史原因需要区分浏览器
 */
	function getRequest() {
		var xmlHttp = null;
		try {
			// Firefox, Opera 8.0+, Safari  chrome
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return xmlHttp;
	} 
</script>
</head>
<body>
	用户名:
	<input id="name" name="username" value="" />
	<br>
	<button onclick="reqWebService()">AJax请求webservice</button>
	<button id="btn">Jquery请求webservice</button>
	<button id="btn2">HttpURLConnection请求webservice</button>
	
</body>
</html>