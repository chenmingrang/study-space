<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	    function showImg(){
	        var div = document.getElementById("imgDiv");
	        if(div.innerHTML==""){
	           document.getElementById("imgDiv").innerHTML="<img src='./barChart2'>";
	        }
	        if(div.style.display=="none"){
	           div.style.display="block";
	        }
	    }
	    function hideImg(){
	        document.getElementById("imgDiv").style.display="none";
	    }
	</script>
  </head>
  
  <body>
    <!--  <input type="button" id ="btn_show" onclick="showImg();" value="显示图片"/>
     <input type="button" id ="btn_hide" onclick="hideImg();" value="隐藏图片"/> -->
     <img src='lineChart2'>
  </body>
</html>
