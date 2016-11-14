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
    
    <title>用户信息查询结果页面</title>
    
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
    List<User> users=find.getUserInfoByUserName();//取得所有记录 
    Iterator<User> it=users.iterator(); //实例化iterator对象
    %>
    <h3 align="center">查询结果</h3>
    
    <table border="1" bgcolor="ccceee" width="650">
    	<tr bgcolor="CCCCCC" align="center">
    		<td>用户号</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>电话</td>
    		<td>用户身份</td>
    		<td>备注</td>
    	</tr>
    	<%
    	User user=new User();
    	while(it.hasNext()){
    		user=it.next();//取得每一个Student对象
    	%>
  	 	<tr>
   		<td><%=user.getId() %></td>
   		<td><%=user.getUsername() %></td>
   		<td><%=user.getPassword() %></td>
   		<td><%=user.getPhone() %></td>
   		<td><%=user.getUserType() %></td>
   		<td><%=user.getAddress() %></td>
    	</tr>
    	<%} %>
    </table>
    </center>
    
  </body>
</html>
