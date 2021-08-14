package com.example.put.controller;

import com.example.put.dto.PutRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutAPIController {

    @PutMapping("/put/{userId}")
    public PutRequestDTO put(@RequestBody PutRequestDTO requestDto, @PathVariable Long userId){
        System.out.println(requestDto);
        System.out.println(userId);
        return requestDto;

    }

}
