<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  <body>
       <s:text name="login.welcome">
          <s:param>
             <!-- action的成员变量名 -->
             <s:property value="username"/>
             <!-- 占位符 -->
          </s:param>
       </s:text>
  </body>
</html>
