<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<div class="g-doc">
	<c:choose>
	<c:when test="${empty products}">
    <div class="n-result">
        <h3>内容不存在！</h3>
    </div>
    </c:when>
    <c:otherwise>
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${products.image}" alt=""></div>
        <div class="cnt">
            <h2>${products.title}</h2>
            <p class="summary">${products.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${products.price}</span>
            </div>
            <div class="oprt f-cb">
            	<c:if test="${!empty user && user.userType==0}">
                    <c:if test="${products.buy}">
                    <span class="u-btn u-btn-primary z-dis">已购买</span>
                    <span class="buyprice">当时购买价格：¥${products.buyPrice}</span>
                    </c:if>
                    <c:if test="${!products.buy}">
                    <button class="u-btn u-btn-primary" data-buy="${products.id}">购 买</button>
                    </c:if>
				</c:if>
				<c:if test="${!empty user && user.userType==1}">
                <a href="edit?id=${products.id}" class="u-btn u-btn-primary">编 辑</a>
                </c:if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${products.detail}
    </div>
    </c:otherwise>
    </c:choose>
</div>
	<div class="n-foot">
		<p>
		</p>
	</div>
	<script type="text/javascript" src="js/global.js"></script>
	<script type="text/javascript" src="js/pageShow.js"></script>
</body>
</html>