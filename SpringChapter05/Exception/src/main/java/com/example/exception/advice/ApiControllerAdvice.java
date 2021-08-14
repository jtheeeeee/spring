package com.example.exception.advice;

import com.example.exception.controller.RsetApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;

//Global은 전역을 예외처리 하지만
//이 클래스는 RestApiController 한정으로 예외처리 한다.
@RestControllerAdvice(basePackageClasses = RsetApiController.class)
public class ApiControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();

        bindingResult.getAllError().forEach(error ->{
            FieldError field = (FieldError) error;
            String fieldName = field.getField();
            String messgae =field.getDefaultMesage();
            String value = field.getRejectValue().toString();
            System.out.println(fieldName);
            System.out.println(messgae);
            System.out.println(value);
        });


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e){
        e.getConstraintViolations().forEach(error -> {
            System.out.println(error);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e){


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
