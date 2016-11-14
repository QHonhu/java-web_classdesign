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
<jsp:include page="/jsp/header.jsp"></jsp:include>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <c:choose>
    <c:when test="${empty buyList}">
    <div class="n-result">
        <h3>暂无内容！</h3>
    </div>
    </c:when>
    <c:otherwise>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>
        <thead>
            <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买价格</th></tr>
        </thead>
        <tbody>
        <c:forEach var="x" items="${buyList}">
            <c:set var="total" value="${total + x.buyPrice}"></c:set>
            <tr>
                <td><a href="show?id=${x.id}"><img src="${x.image}" alt=""></a></td>
                <td><h4><a href="show?id=${x.id}">${x.title}</a></h4></td>
                <td><span class="v-time">${x.buyTime}</span></td>
                <td><span class="v-unit">¥</span><span class="value">${x.buyPrice}</span></td>
            </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="3"><div class="total">总计：</div></td>
                <td><span class="v-unit">¥</span><span class="value">${total}</span></td>
            </tr>
        </tfoot>
    </table>
    </c:otherwise>
    </c:choose>
</div>
<div class="n-foot">
</div>
</body>
</html>