package com.sparta.item01.domain;

import com.sparta.item01.dto.LectureRequestDto;
import com.sparta.item01.dto.PersonRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity // 테이블임을 나타냅니다.
public class Person extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String job;

    @Column(nullable =  false)
    private int age;

    public void update(PersonRequestDto requestDto) {
        this.name =requestDto.getName();
        this.address = requestDto.getAddress();
        this.age = requestDto.getAge();
        this.job=requestDto.getJob();

    }


}