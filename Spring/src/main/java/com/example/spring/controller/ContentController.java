package com.example.spring.controller;

import com.example.spring.domain.Content;
import com.example.spring.dto.ContentRequestDto;
import com.example.spring.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/content")
    public Content setContent(@RequestBody ContentRequestDto contentRequestDto){
        return contentService.setContent(contentRequestDto);
    }

    @GetMapping("/contents")
    public List<Content> getContents(){
        return contentService.getContents();
    }

    @GetMapping("/content/{id}")
    public Content getContent(@PathVariable Long id){
        return contentService.getContent(id);
    }

    @PostMapping("/content/comment")
    public o
}
