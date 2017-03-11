<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    </head>
  <body>
    <form action="${pageContext.request.contextPath}/upload/uploadAction_saveFile.action"  
          name="form1"  method="post"  enctype="multipart/form-data" >
             
             上传文件名称:<input type="file" name="upload">
           <input type="submit" value="上传">
    </form>
    <s:fielderror/>
  </body>
</html>
