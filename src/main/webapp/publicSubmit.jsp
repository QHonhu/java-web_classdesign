<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<jsp:include page="/jsp/header.jsp"></jsp:include>
<div class="g-doc">
    <div class="n-result">
        <h3>${message}！</h3>
        <a href="./index">[返回首页]</a></p>
    </div>
</div>
<jsp:include page="/jsp/footer.jsp"></jsp:include>
</body>
</html>