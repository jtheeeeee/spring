package com.example.response.controller;


import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class APIController {
    //TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    //JSON
    //request -> obejct mapper -> obejct -> method -> object Mapper -->json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user; //200ok
    }

    //http status 코드도 지정해줄 수 있고, body에 데이터도 넣어줄 수 있다.
    //헤더값도 추가가 가능하다.
    //응답에 대해 커스터마이징을 하고 싶을때 ResponseEntity를 쓰면 된다.
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
       return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
