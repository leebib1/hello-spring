package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러 기능을 하는 스프링 빈으로 등록
//@Component //스프링 빈으로 등록
//@RequestMapping //클래스 레벨에 붙어있으면 매핑 정보로 인식 스프링 부트 3.0(스프링 프레임워크 6.0)부터는 스프링 컨트롤러로 인식하지 않음.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form") //요청 정보 매핑
    public ModelAndView process() {
        return new ModelAndView("new-form"); //모델뷰 반환
    }
}
