package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")
@Validated
public class RsetApiController {

    @GetMapping("")   // @RequestParam(required =false) String name 꼭 필수적으로 들어가지 않아도 되고, 안들어갈 경우 null로 들어간다.
    public User get(
            @Size(min=2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);




        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){

        System.out.println(user);
        return user;

    }

    //이 클래스 안에서 동작함.
    //같은 클래스내의 exceptionHandler 먼저 타게된다...
    //예외 처리: 2. 특정 API에서 처리
   /* @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        System.out.println("apiController");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }*/
}
