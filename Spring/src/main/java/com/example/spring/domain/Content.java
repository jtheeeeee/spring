package com.example.spring.domain;
import com.example.spring.dto.ContentRequestDto;
import com.example.spring.repository.ContentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Content {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    public Content(ContentRequestDto contentRequestDto){
        this.content=contentRequestDto.getContent();

    }
}
