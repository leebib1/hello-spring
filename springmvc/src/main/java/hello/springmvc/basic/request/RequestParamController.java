package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody //View 조회를 무시하고 응답 메시지 바디에 반환 String을 바로 넣어 준다.
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, //가져올 요청 파라미터의 name 값을 생략할 수 있지만 키값과 받는 변수명이 동일해야 함.
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) { //@RequestParam 애노테이션도 생략 가능하지만 단순 데이터이고 요청 데이터와 일치 해야함.
        // 단, 생략할 때 오히려 가독성이 떨어지지 않도록 주의 해야한다.
        // 너무 많은 정보가 생략 되어서 구분하기 힘들지 않도록 해야함.
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, //true인 경우가 default로 해당 파라미터가 필수로 있어야 한다.
            @RequestParam(required = false) int age //false를 주면 해당 파라미터가 없는 경우 받지 않고 넘어간다.
    ) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, //defaultValue가 있는 경우 required 속성이 무의미함
            @RequestParam(required = false, defaultValue = "-1") int age //값이 없는 경우 defaultValue에 지정한 값을 받아온다.
    ) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-attribute-v2")
    public String modelAttributeV2(HelloData helloData) { //@ModelAttribute 생략 가능
        //String , int , Integer 같은 단순 타입 = @RequestParam
        //나머지 = @ModelAttribute (argument resolver 로 지정해둔 타입 외)
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return "ok";
    }
}
