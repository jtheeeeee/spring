package com.sparta.item01.controller;

import com.sparta.item01.dto.PersonRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public PersonRequestDto getPerson() {
        PersonRequestDto personRequestDto = new PersonRequestDto("손흥민","영국",22,"축구선수");
        return personRequestDto;
    }
}