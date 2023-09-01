package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping //Get방식으로 요청이 들어오면 해당 메소드 실행
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") //내장 톰캣 서버를 거치면서 helloController에서 매핑된 값이 있는 메소드를 찾음
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template"; //viewResolver(뷰를 찾고 탬플릿 엔진 연결)가 template/반환값.html을 찾음
        //Thymeleaf 템플릿 엔진이 렌더링 후 변환한 html을 웹브라우저에 반환
        //정적일 때는 변환 없이 반환되지만 동적인 경우 변환 후 반환한다.
    }

    @GetMapping("hello-string")
    @ResponseBody //HTTP(클라이언트가 응답받는 곳)의 BODY에 반환값을 직접 넣어준다.
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; //아무런 태그 없이 문자만 화면에 출력됨
    }

    @GetMapping("hello-api")
    @ResponseBody
    //@ResponseBody 애너테이션이 있으면 viewResolver 대신 HttpMessageConverter가 동작한다.
    //반환 타입이 객체인 경우 JsonConverter가 동작하고 String인 경우 StringConverter가 동작한다.
    //기본 문자 처리  : StringHttpMessageConverter
    //기본 객체 처리 : MappingJackson2HttpMessageConverter
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello; //{"name":"spring"} JSON 방식으로 데이터가 넘어간다.(key:value 형식)
        //xml 방식은 무겁기 때문에 요즘 사용하지 않고 JSON 방식으로 처리하는 방식으로 사용한다.
    }

    static class Hello{ //static으로 클래스 생성 후 사용
        private String name;
        //ctrl+n으로 메소드 검색해서 getter, setter 메소드 생성
        public String getName(){
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
