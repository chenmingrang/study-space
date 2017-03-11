<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>    
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  <body>
  <br>
     <s:text name="item.username"/><br>
     
    <!-- item.test={0} 是  {1}  -->
     <s:text name="item.test">
       <s:param>用户名0</s:param>
       <s:param>密码1</s:param>
     </s:text>
  </body>
</html>
