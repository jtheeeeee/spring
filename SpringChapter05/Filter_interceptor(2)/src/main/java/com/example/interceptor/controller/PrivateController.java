package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Auth // interceptor 에서 @Auth 어노테이션이 붙은 것만 통과시키게 할것이다,,
@Slf4j
public class PrivateController {

    @GetMapping("/hello")
    public String hell(){

        log.info("private hello controller");
        return "private hello";
    }
}
