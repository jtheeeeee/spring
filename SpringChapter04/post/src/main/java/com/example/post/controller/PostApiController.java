package com.example.post.controller;

import com.example.post.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    /*@PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        *//* 아래랑 같은 것
        requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key : "+stringObjectEntry.getKey());
            System.out.println("value : "+stringObjectEntry.getValue());
        });
        *//*
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }*/

    @PostMapping("/post")
    public void post(@RequestBody PostRequestDTO requestData){
        System.out.println(requestData);
    }




}
