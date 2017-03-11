<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    ${requestScope.username}<br>
    ${sessionScope.username}<br>
    ${applicationScope.username}<br>
  </body>
</html>
