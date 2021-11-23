package com.example.spring.service;

import com.example.spring.domain.Content;
import com.example.spring.dto.ContentRequestDto;
import com.example.spring.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public Content setContent(ContentRequestDto contentRequestDto){
        Content content = new Content(contentRequestDto);
        contentRepository.save(content);
        return content;

    }

    public List<Content> getContents(){
        return contentRepository.findAll();
    }

    public Content getContent(Long id){
        return contentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
    }



}
