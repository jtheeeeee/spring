package com.example.filter.controller;


import com.example.filter.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//test용 컨트롤러
//ApiController에만 필터를 적용시킬수도 있다.
@Slf4j //sout으로 남기던 로그를 롬복을 사용할 때 쓰는 어노테이션
@RestController
@RequestMapping("/api/temp")
public class ApiuserController {
    @PostMapping("")
    public User user(@RequestBody User user){
        log.info("Temp : {}", user);

        return user;

    }
}
