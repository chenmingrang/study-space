<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>    
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  <body>
  <br>
      <s:form name="loginForm" method="post"  namespace="/validate"  action="validateAction_login.action" theme="simple" >
         <table>
           <tr>
              <td>用户名</td>
              <td> <s:textfield name="username" /></td>
              <td><s:fielderror fieldName="name"/></td>
           </tr>
           <tr>
              <td>密码</td>
              <td><s:password name="psw" /></td>
              <td>
                 <s:fielderror fieldName="pwd"/>
              </td>
           </tr>
           <tr>
              <td>&nbsp;</td>
              <td><s:submit value="登陆"/></td>
           </tr>
         </table>
     </s:form>
  </body>
  
  <a href="${pageContext.request.contextPath}/validate/validateAction_test.action">test其他的方法</a>
  
</html>
