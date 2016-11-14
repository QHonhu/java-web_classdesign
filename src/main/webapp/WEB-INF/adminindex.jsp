<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>管理员主页</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="g-doc">
    <div class="n-result">
		<a href="<%=request.getContextPath()%>/find_all_user.jsp">>查询所有用户信息</a><br>
		<a href="<%=request.getContextPath()%>/find_all_merchandise.jsp">>查询所有商品信息</a><br>
		<a href="<%=request.getContextPath()%>/find_all_trx.jsp">>查询所有订单信息</a><br>
		<form action="delete_userid" method="post">
			>删除用户的信息<br>
			<input type="text" name="userid" >&nbsp;<input type="submit" value="确定"/>
		</form>
		<form action="delete_goodsid" method="post">
			>删除商品的信息<br>
			<input type="text" name="goodsid" >&nbsp;<input type="submit" value="确定"/>
		</form> </div>
</div>
<jsp:include page="/jsp/footer.jsp"/>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/pageIndex.js"></script>
</body>
</html>