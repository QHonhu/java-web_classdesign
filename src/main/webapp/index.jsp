<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>java</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel"><a href="./index.jsp">所有内容</a></li>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <c:choose>
                <c:when test="${empty user}">
                <c:forEach var="product" items="${productlist}">
                <li id="p-${product.id}">
                    <a href="./show?id=${product.id}" class="link">
                        <div class="img"><img src="${product.image}" alt="${product.title}"></div>
                        <h3>${product.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${product.price}</span></div>
                    </a>
                </li>
				</c:forEach>
				</c:when>
        <c:otherwise>
        <c:forEach var="product" items="${productlist}">
                <li id="p-${product.id}">
                    <a href="./show?id=${product.id}" class="link">
                        <div class="img"><img src="${product.image}" alt="${product.title}"></div>
                        <h3>${product.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${product.price}</span></div>
                        <c:if test="${!empty user && user.userType==0 && product.buy}"><span class="had"><b>已购买</b></span></c:if>
                        <c:if test="${!empty user && user.userType==1 && product.sell}"><span class="had"><b>已售出</b></span></c:if>
                    </a>
                    <c:if test="${!empty user && user.userType==1 && user.sell}"><span class="u-btn u-btn-normal u-btn-xs del" data-del="${product.id}">删除</span></c:if>
                </li>
                </c:forEach>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
<div class="n-foot">
</div>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/pageIndex.js"></script>
</body>
</html>