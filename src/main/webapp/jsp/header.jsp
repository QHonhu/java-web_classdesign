<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
             <c:if test="${!empty user}"><c:if test="${user.userType==0}">买家你好，</c:if><c:if test="${user.userType==1}">卖家你好，</c:if><span class="name">${user.username}</span>！<a href="./logout">[退出]</a></c:if>
            <c:if test="${empty user}">请<a href="./login.jsp">[登录]</a></c:if>
        </div>
        <ul class="nav">
            <li><a href="index">首页</a></li>
             <c:if test="${user.userType==0}">
            <li><a href="./account">账务</a></li>
             </c:if>
            <c:if test="${user.userType==1}">
            <li><a href="./public.jsp">发布</a></li>
            </c:if>
        </ul>
    </div>
</div>
</body>
</html>