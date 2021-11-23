package com.example.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/")
    public String getPageIndex(){
        return "index.html";
    }

    @GetMapping("/view")
    public String getPageView(){
        return "view.html";
    }
}
