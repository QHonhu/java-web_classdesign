<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.lzw.web.dao.impl.*" %>
<%@ page import="com.lzw.web.meta.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单信息查询结果页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <center>  
  <% 
  	JdbcDaoAdministratorImpl find=new JdbcDaoAdministratorImpl();
    List<Trx> trxs=find.getTrxInfoById();//取得所有记录 
    %>
    <h3 align="center">查询结果</h3>
    
    <table border="1" bgcolor="ccceee" width="650">
    	<tr bgcolor="CCCCCC" align="center">
    		<td>订单号</td>
    		<td>发布号</td>
    		<td>价格</td>
    		<td>时间</td>
    	</tr>
    	<%
    	for(Trx trx : trxs){
    	%>
  	 	<tr>
   		<td><%=trx.getContentId() %></td>
   		<td><%=trx.getPersonId() %></td>
   		<td><%=trx.getPrice() %></td>
   		<td><%=trx.getPrice() %></td>
   		<td><%=trx.getTime() %></td>
    	</tr>
    	<%} %>
    </table>
    </center>
    
  </body>
</html>
