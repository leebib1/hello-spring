<%--<%@ page import="hello.servlet.domain.member.Member" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <%--<li>id=<%=((Member)request.getAttribute("member")).getUsername()%>></li>--%>
    <%--위 코드처럼 길게 쓰지 않아도 프로퍼티 접근법을 사용해서 단순하게 작성할 수 있다.--%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
