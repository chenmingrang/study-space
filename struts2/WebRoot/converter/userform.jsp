<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    </head>
  <body>
    <form action="${pageContext.request.contextPath}/converter/userAction_save.action" 
          name="form1"  method="post">
        编号:<input type="text" name="id"><br>
        姓名:<input type="text" name="userName"><br>
   出生日期：<input type="text" name="createTime"><br>
        
        
        
        学历编号:<input type="text" name="edu.eduid"><br>
        学历名称:<input type="text" name="edu.eduname"><br>
       
       
       
        员工姓名:<input type="text" name="emps[0].name"><br>
        员工薪水:<input type="text" name="emps[0].salary"><br>
       
      
        员工姓名:<input type="text" name="emps[1].name"><br>
        员工薪水:<input type="text" name="emps[1].salary"><br>
         
       <input type="submit" value="提交"><br>
    </form>
  </body>
</html>
