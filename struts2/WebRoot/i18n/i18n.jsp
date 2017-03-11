<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>    
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  <body>
       <a href="lang.action?request_locale=zh_CN">中文</a>
       <a href="lang.action?request_locale=en_US">English</a>
       <s:i18n name="cn.itcast.i18n.resources">
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
              <td><s:text name="item.test"/></td>
              <td><input type="submit" value="<s:text name='items.login'/>"/></td>
           </tr>
         </table>
     </form>
     </s:i18n>
  </body>
</html>
