<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ex07- 데이터 전달</title>
</head>
<body>
    <%-- JSP 페이지 간의 데이터 전달--%>
    <%--1. application--%>
    <%--2. pageContext--%>
    <%--3. request--%>
    <%--4. session--%>
    <%--5. GET 방식으로 주소줄에 데이터 전달--%>
    <%--6. input type=hidden submit 사용--%>
    <%--7. jsp:forward jsp:param--%>
    <%--8. c:redirect c:param--%>

    <!-- 내장 객체의 수명 -->
    <!--                                   servletContext -->
    <!-- pageContext < request < session < application -->
    <!-- 한페이지       단일요청   로그아웃전   웹브라우저 닫히기전까지 -->
    <!--               Model : Spring MVC -->
    <!--               단일함수 -->

    <!-- JSP 액션태그  -->
    <jsp:forward page="ex08.jsp">
        <jsp:param name="id" value="hong" />
        <jsp:param name="pw" value="1234" />
    </jsp:forward>

</body>
</html>

</body>
</html>