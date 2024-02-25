<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- /없이 상대경로 사용하면 현재 URL이 속한 계층 경로 + /save 가 된다. 일반적으론 절대경로를 작성해주는 것이 좋음. -->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>