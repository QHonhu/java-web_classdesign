<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.lzw.web.meta.*"%>
<%@ page import="com.lzw.web.dao.impl.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询全部商品的信息</title>
    
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
 			JdbcDaoAdministratorImpl finds=new JdbcDaoAdministratorImpl();
 			List<Merchandise> goods=finds.getMerchandiseInfoById();
 			Iterator<Merchandise> it=goods.iterator();     //iterator迭代器，实例化对象
 		%>
 		 <h3 align="center">查询结果</h3>
    
    	<table border="1" bgcolor="ccceee" width="650">
    	<tr bgcolor="CCCCCC" align="center">
    		<td>商品号</td>
    		<td>商品名称</td>
    		<td>价格</td>
    		<td>摘要</td>
    		<td>详细介绍</td>
    	</tr>
    	<%
    	Merchandise merchandise=new Merchandise();//创建商品对象
    	while(it.hasNext()){	
    		//merchandise=new Merchandise();
    		merchandise=it.next();//取得每一个商品对象
    	
    	%>
    	<tr>
   		<td><%=merchandise.getId() %></td>
   		<td><%=merchandise.getTitle() %></td>
   		<td><%=merchandise.getPrice() %></td>
   		<td><%=merchandise.getDetail()%></td>
   		<td><%=merchandise.getSummary() %></td>
   		<td><img src=<%=merchandise.getImage() %>  alt=<%=merchandise.getTitle() %> /></td>
    	</tr>
    	<%} %>
    	
    	</table>
    	</center>
    	
  </body>
<ml>
