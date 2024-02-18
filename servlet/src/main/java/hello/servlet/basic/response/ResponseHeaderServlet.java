package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setStatus(HttpServletResponse.SC_OK); //200이라고 쓰는 것보다 바로 의미를 확인해줄 수 있게 지정된 상수를 사용하는 것이 좋다.
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello"); //내가 헤더에 넣고싶은 값을 추가로 넣어줄 수 있음.

        //Header 편의 메소드
//        content(response);

        //Cookie 편의 메소드
//        cookie(response);

        //Redirect 편의 메소드
        redirect(response);

        //message body
        PrintWriter writer = response.getWriter();
        writer.write("OK");
    }

    //Content 편의 메소드
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    //쿠키 편의 메소드
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초 : 쿠키 생명주기
        response.addCookie(cookie);
    }

    //리다이렉트 편의 메소드
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html"); //위 코드 두 줄 대신 sendRedirect()메소드 하나로 지정할 수 있다.
    }
}
