<%@ page contentType="text/html;charset=UTF-8" language="java" %><%--JSP 파일이라는 구분 태그. 필수로 있어야한다. --%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>

</body>
</html>
