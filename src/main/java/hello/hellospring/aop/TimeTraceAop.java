package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //SpringConfing에 Bean으로 등록해도 됨
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))") //타켓팅 특정 : 패키지명 하위에 다 적용함
    //hello.hellospring 패키지 하위에 모든 것, 모든 파라미터
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start=System.currentTimeMillis();
        System.out.println("START : "+joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish=System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("END : "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
