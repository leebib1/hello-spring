package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloservlet", urlPatterns = "/hello") //url이 /hello 일때 해당 서블릿 실행
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //servlet이 실행될 때 service()가 실행
        System.out.println("HelloSerlvet.service");
        System.out.println("request = " + request); //request = org.apache.catalina.connector.RequestFacade@744092d1
        System.out.println("response = " + response); //response = org.apache.catalina.connector.ResponseFacade@6cbde39e

        //요청 데이터 확인
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //응답 메시지
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
