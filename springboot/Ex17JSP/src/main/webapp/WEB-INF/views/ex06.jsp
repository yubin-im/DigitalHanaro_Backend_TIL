<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex06</title>
</head>
<body>
    <%--JSTL: JavaServer Page Standerd Tag Library--%>
    <%--JSP에서 추가확장 기능을 제공. <c>태그 사용.--%>
    <c:import url="./ex06_header.jsp" />
    <h1> Main 콘텐츠 </h1>
    <c:import url="./ex06_footer.jsp" />
</body>
</html>