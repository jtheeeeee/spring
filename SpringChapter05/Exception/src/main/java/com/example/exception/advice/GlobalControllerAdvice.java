package com.example.exception.advice;

import com.example.exception.controller.RsetApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//전체 시스템에 적용시키고 싶을 때는 이 어노테이션을 쓴다.
//예외처리: 1. 전역으로 처리
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e){

        System.out.println(e.getClass().getName());
        System.out.println("-------------------------");
        System.out.println(e.getLocalizedMessage());

        System.out.println("-------------------------");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
