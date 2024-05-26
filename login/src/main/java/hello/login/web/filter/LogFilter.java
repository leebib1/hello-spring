package hello.login.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("log filter doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) request; //ServletRequest에 큰 기능이 없기 때문에 다운캐스팅
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString(); //요청 구분을 위해 uuid 임시 생성

        try{
            log.info("REQUEST [{}][{}]", uuid, requestURI);
            chain.doFilter(request, response); //다음 필터가 있으면 필터를 호출하고 필터가 없으면 서블릿을 호출한다. 이 로직을 호출하지 않으면 다음 단계로 진행되지 않음.
        } catch (Exception e) {
            throw e;
        }finally {
            log.info("RESPONSE [{}][{}]", uuid, requestURI);
        }

    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
