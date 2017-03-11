<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    </head>
  <body>
     访问BookAction_add 测试action标签中的method属性<br> 
    <a href="${pageContext.request.contextPath}/pattern/bookAction.action"> 测试</a><br>
    <br> 
    <br>
    
     
     通配符映射示例(1):<br>
    <a href="${pageContext.request.contextPath}/pattern/a_add.action"> 通配符映射示例(1)</a><br>
    <a href="${pageContext.request.contextPath}/pattern/b_add.action"> 通配符映射示例(1)</a><br>
    <a href="${pageContext.request.contextPath}/pattern/c_add.action"> 通配符映射示例(1)</a><br>
    <br> 
    <br>
    <br>
    
     通配符映射示例(2):<br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction_add.action"> 图书</a><br>
    <a href="${pageContext.request.contextPath}/pattern/UserAction_add.action">用户</a><br>
     <br>
     <br>
     
     通配符映射示例(3):<br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction_add.action">图书添加</a><br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction_delete.action">图书删除</a><br>
     <br>
     <br>
    <a href="${pageContext.request.contextPath}/pattern/UserAction_add.action">用户添加</a><br>
    <a href="${pageContext.request.contextPath}/pattern/UserAction_delete.action">用户删除</a><br>
    <br>
     <br>
   
   
     动态方法调用!形式:<br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction!add.action">图书添加</a><br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction!delete.action">图书删除</a><br>
   
   
     <br><br>
     使用通配符定义action<br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction_add.action">图书添加</a><br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction_delete.action">图书删除</a><br>
    
     <br><br>
     测试全局和局部的action<br>
    <a href="${pageContext.request.contextPath}/pattern/BookAction_find.action">图书查找</a><br>
 
  </body>
</html>
