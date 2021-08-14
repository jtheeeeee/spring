package com.example.get.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class는 REST API를 처리하는 Controller로 인식함
@RequestMapping("/api") //RequestMapping은 URI를 지정해주는 Annotation
                           // 주소를 할당해주기 위해서 필요하다.
public class ApiController {

    @GetMapping("/hello") // http://localhost:8080/api/hello
    public String hello(){
        return "hello spring boot"; // http://localhost:8080:api/hello 라는 주소로 get방식으로 요청이 들어오면 해당 문자열을 Return
    }
}
