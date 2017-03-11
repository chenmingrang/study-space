<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>    
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  <body>
       <form name="loginForm" method="post" 
            action="${pageContext.request.contextPath}/i18n/i18nAction_login.action">
         <table border="1">
           <tr>
              <td><s:text name="items.username" /></td>
              <td><input type="text" name="username"/></td>
           </tr>
           <tr>
              <td><s:text name="items.psw" /></td>
              <td><input type="password" name="psw"/></td>
           </tr>
         <tr>
              <td>&nbsp;</td>
              <td><input type="submit" value="<s:text name='items.login'/>"/></td>
           </tr>
         </table>
     </form>
  </body>
</html>
