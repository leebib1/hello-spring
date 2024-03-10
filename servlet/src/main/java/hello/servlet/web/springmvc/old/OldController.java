package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("/springmvc/old-controller") //스프링 빈 이름을 url로 매핑
//HandlerMapping : BeanNameUrlHanlderMapping(스프링 빈의 이름으로 핸들러를 찾음)
//HandlerAdapter : SimpleControllerHandlerAdapter(Controller 인터페이스. 애노테이션이 없이 과거에 사용하던 것으로 처리)
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        
        return new ModelAndView("new-form");
    }
}
