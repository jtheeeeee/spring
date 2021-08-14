package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")  //메서드이름 중요하지 않음. 어노테이션만 잘 붙이면됨.
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode(){}

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object [] args = joinPoint.getArgs();
        for(Object obj : args){
            if(obj instanceof User){

                User user = User.class.cast(obj);
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email),"UTF-8");
                user.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        if(returnObj instanceof User){
            User user = User.class.cast(returnObj);
            String email = user.getEmail();
            String base64Email = new String(Base64.getEncoder().encodeToString(email.getBytes()));
            user.setEmail(base64Email);
        }
    }
}
