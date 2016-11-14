<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>java</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="/jsp/header.jsp"></jsp:include>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel"><a href="./index.jsp">所有内容</a></li>
               <c:if test="${!empty user && user.userType==0}"><li><a href="./index.jsp">未购买的内容</a></li></c:if>
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
            <c:choose>
                <c:when test="${!empty user && user.userType == 0}">
                <c:forEach var="product" items="${productlist}">
                <c:if test="${product.buy}">
                <li id="p-${product.id}">
                    <a href="/web-work/show?id=${product.id}" class="link">
                        <div class="img"><img src="${product.image}" alt="${product.title}"></div>
                        <h3>${product.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${product.price}</span></div>
                    </a>
                </li>
                </c:if>
				</c:forEach>
				</c:when>
        <c:otherwise>
        <c:forEach var="product" items="${productlist}">
                <li id="p-${product.id}">
                    <a href="/web-work/show?id=${product.id}" class="link">
                        <div class="img"><img src="${product.image}" alt="${product.title}"></div>
                        <h3>${product.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${product.price}</span></div>
                        <c:when test="${!empty user && user.userType==0 && product.buy}">s<span class="had"><b>已购买</b></span></c:when>
                        <c:when test="${!empty user && user.userType==1 && product.sell}"><span class="had"><b>已售出</b></span></c:when>
                    </a>
                    <c:if test="${!empty user && user.usertype==1 && !x.isSell}"><span class="u-btn u-btn-normal u-btn-xs del" data-del="${product.id}">删除</span></c:if>
                </li>
                </c:forEach>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/pageIndex.js"></script>
</body>
</html>