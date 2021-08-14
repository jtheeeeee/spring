package com.example.filter.controller;


import com.example.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //sout으로 남기던 로그를 롬복을 사용할 때 쓰는 어노테이션
@RestController
@RequestMapping("/api/user")
public class ApiController {
    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("User : {}", user);

        return user;

    }
}
