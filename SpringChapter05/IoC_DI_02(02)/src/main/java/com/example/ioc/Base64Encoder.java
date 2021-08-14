package com.example.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

//이 빈의 이름은 base74Encoder라고 변한 것이다.
@Component("base74Encoder") //스프링 빈으로 등록된다.
public class Base64Encoder implements IEncoder {

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
