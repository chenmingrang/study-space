<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    </head>
  <body>
    <form action="${pageContext.request.contextPath}/pattern/xxxAction.action"  name="form1"  method="post">
             用户名:<input type="text" name="username">
           <input type="submit" value="提交">
    </form>
  </body>
</html>
