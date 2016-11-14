<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退出页面</title>
<link rel="stylesheet" href="/online-mall/css/style.css"/>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="g-doc">
    <div class="n-result">
        <h3>您已退出！</h3>
        <a href="<%=request.getContextPath()%>/login.jsp">[再次登录]</a></p>
    </div>
</div>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>