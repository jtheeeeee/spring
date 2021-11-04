package com.sparta.item01.service;

import com.sparta.item01.domain.Lecture;
import com.sparta.item01.domain.LectureRepository;
import com.sparta.item01.domain.Person;
import com.sparta.item01.domain.PersonRepository;
import com.sparta.item01.dto.LectureRequestDto;
import com.sparta.item01.dto.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class PersonService {

    private final PersonRepository psersonRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto) {
        Person person1 = psersonRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        person1.update(requestDto);
        return person1.getId();
    }
}