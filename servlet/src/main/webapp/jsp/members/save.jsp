<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%-- %@ page import="임포트할 파일(패키지 포함)"--%>
<%!
    private hello.servlet.domain.member.MemberRepository MemberRepository;
%><% //<- 태그로 자바 코드 시작
    // request, response 사용 가능
    //실행될 때 내부에서 Servelt으로 변경됨.
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
    <li>id=<%=member.getId()%></li><%-- %=을 쓰면 자바 코드를 출력할 수 있다--%>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>

</body>
</html>
