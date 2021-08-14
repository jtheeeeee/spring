package com.example.aop.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect    //configuration 하나의 클래스에 여러가지 빈이 등록된다,, 먼말이지,,
@Component //빈하고 컴포넌트 차이(빈에는 클래스에 붙일 수 없음) 빈은 메서드에 붙일 수 있음.
public class TimerAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")  //메서드이름 중요하지 않음. 어노테이션만 잘 붙이면됨.
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){}

    // 시간을 재는 로직 자체는 비즈니스 로직이 아닌 부가적인 로직인데
    // 만약 AOP 가 없었다면 RestApiController의 모든 메서드에서
    // 시간을 잰다고 했을때 아래 있는 코드가 다 들어가야한다.
    // 실제 비즈니스 로직이 아님에도 들어가서 코드가 보기 힘들어지고 지저분해진다.
    // 그래서 AOP를 활용하여 빼낸 것이다. 분리 굿
    // 모든 메서드에 같은 기능들을 쓸 수 있게 해준다.
    // 실제 서비스 로직에서 쓰면 된다.
    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        System.out.println("total time : "+stopWatch.getTotalTimeSeconds());
    }

}
