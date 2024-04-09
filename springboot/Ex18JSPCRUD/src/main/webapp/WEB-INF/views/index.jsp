<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원목록조회</title>
</head>
<body>
    <h2 th:text="|회원목록 (총 ${list.size()}명)|">회원 목록</h2>
    <table border="1">
        <thead>
            <tr align="center">
                <td>일련번호</td>
                <td>ID</td>
                <td>아이디</td>
                <td>비밀번호</td>
                <td>이름</td>
                <td>권한</td>
                <td>가입일</td>
                <td>단건조회</td>
                <td>삭제</td>
            </tr>
        </thead>
        <tbody>
        <tr th:each="member, status : ${list}" align="center">
            <td><span th:text="${status.count}"></span></td>
            <td><span th:text="${member.id}"></span></td>
            <td><span th:text="${member.userId}"></span></td>
            <td><span th:text="${member.userPw}"></span></td>
            <td><span th:text="${member.userName}"></span></td>
            <td><span th:text="${member.userRole}"></span></td>
            <td><span th:text="${member.joinDate}"></span></td>
            <td>
                <!-- http://localhost:8080/viewDTO?id=${member.id} -->
                <button type="button" th:onclick="|location.href='@{viewMember(id=${member.id})}'|">단건조회</button>
            </td>
            <td>
                <!-- http://localhost:8080/deleteDTO?id=${member.id} -->
                <button type="button" th:onclick="|location.href='@{deleteMember(id=${member.id})}'|">삭제</button>
            </td>
        </tr>
        </tbody>
    </table>

    <br>
    <button type="button" onclick="location.href='joinForm'">회원가입</button>
</body>
</html>