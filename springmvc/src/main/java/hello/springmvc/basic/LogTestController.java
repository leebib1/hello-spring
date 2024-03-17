package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestController 애노테이션을 쓰면 String을 반환 했을 때 RequestBody에 문자를 그대로 반환해준다.
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        //log 레벨 설정을 debug로 둔 상태로 trace 레벨 로그를 출력하는 코드를 입력하면 로그 출력은 되지 않지만 로그를 출력하기 위해 문자열을 계산하는 연산 과정이 일어난다.
        //log.trace(" trace log="+name); //java는 연산을 먼저 처리한다. log={}, name으로 작성한 경우에는 연산처리가 없어서 문제되지 않음.

        //log 레벨의 심각한 순서대로 나열
        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error(" error log={}", name);

        return "ok";
    }
}
