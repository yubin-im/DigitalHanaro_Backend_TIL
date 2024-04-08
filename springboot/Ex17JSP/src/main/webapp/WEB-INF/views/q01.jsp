<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jsp 연습문제</title>
</head>
<body>
<%--연습문제 (JSTL/EL로 출력하시오.)--%>

<%--1. forEach를 이용하여 1부터 100까지의 합을 구하시오.--%>
<c:set var="sum" value="0" />

<c:forEach var="i" begin="1" end="100" step="1">
    <c:set var="sum" value="${sum + i}" />
</c:forEach>

합계: <c:out value="${sum}" />

<%--2. 구구단 7단을 출력하시오.--%>
<c:forEach var="i" begin="1" end="9" step="1">
    7 * ${i} = <c:out value="${7*i}" /><br>
</c:forEach>

<%--3. 1부터 100사이의 2의 배수이면서 5의 배수인 수만 출력하시오.--%>
<c:forEach var="i" begin="0" end="100" step="10">
    ${i}<br>
</c:forEach>

</body>
</html>