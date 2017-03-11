<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    </head>
  <body>
       入门的路径:<br>  
      <a href="${pageContext.request.contextPath}/primer/helloWorldAction.action">helloWorld</a><br>
     
 
       测试Action名称的搜索顺序:<br>
        <a href="${pageContext.request.contextPath}/primer/primer/aaa/primer/helloWorldAction.action">helloWorld</a><br>
        <a href="${pageContext.request.contextPath}/primer/primer/helloWorldAction.action">helloWorld</a><br>
        <a href="${pageContext.request.contextPath}/primer/helloWorldAction.action">helloWorld</a><br>
 
        没有为action指定class<br>
           <a href="${pageContext.request.contextPath}/primer/actionNoClass.action">helloWorld</a><br>
           
        
      测试struts2 输出没有命名空间helloworld:<br>
        <a href="${pageContext.request.contextPath}/primer/userAction.action">helloWorld</a><br>
 
        
        
      
 
      
  </body>
</html>
