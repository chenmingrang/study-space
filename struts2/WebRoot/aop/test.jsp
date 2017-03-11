<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    </head>
  <body>
      测试拦截器:<br>
        <a href="${pageContext.request.contextPath}/aop/userAction_save.action">test</a><br>
  
  </body>
</html>
