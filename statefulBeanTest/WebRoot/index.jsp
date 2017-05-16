<%@ page import="java.util.Properties" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ejb.sfsb.remote.StatefulBeanRemote" %>
<html>
<head>
  <title>测试页面</title>
</head>
<body>
<%
  StatefulBeanRemote bean = null;
  if(session.getAttribute("sfsb")==null){
    Properties props = new Properties();
    //JBoss实现配置
    //Context.INITIAL_CONTEXT_FACTORY ===>  org.jnp.interfaces.NamingContextFactory
    //Context.PROVIDER_URL  ===> localhost:port
    //java.naming.factory.url.pkgs  ===> org.jboss.naming:org.jnp.interfaces可选
    props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
    props.setProperty(Context.PROVIDER_URL, "t3://192.168.71.1:7001");
    InitialContext ctx = new InitialContext(props);
    //#后面的包路径必须和ejb中一致
    //如果是JBoss部署写成HelloWord/remote即可
    //接口可以打成jar包
    bean = (StatefulBeanRemote) ctx.lookup("StatefulBeanEJB#com.ejb.sfsb.remote.StatefulBeanRemote");
    session.setAttribute("sfsb",bean);
  }else {
    bean = (StatefulBeanRemote)session.getAttribute("sfsb");
  }
  String bookname = request.getParameter("bookname");
  if(bookname!=null){
    bookname = new String(bookname.getBytes("ISO8859_1"),"utf-8");
    bean.add(bookname);
  }
  out.println("您已购买："+bean.list());
%>
<table>
  <tr>
    <td>name</td>
    <td>购买</td>
  </tr>
  <tr><td>abc</td><td><a href="index.jsp?bookname=abc">mai</a></td></tr>
  <tr><td>def</td><td><a href="index.jsp?bookname=def">mai</a></td></tr>
  <tr><td>ghi</td><td><a href="index.jsp?bookname=ghi">mai</a></td></tr>
</table>
</body>
</html>
