package com.prac.prac.domain;


import com.prac.prac.dto.PersonRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String job;

    public void update(PersonRequestDto requestDto) {
        this.name=requestDto.getName();
        this.address=requestDto.getAddress();
        this.age=requestDto.getAge();
        this.job=requestDto.getJob();
    }

    public Person(PersonRequestDto requestDto){
        this.name=requestDto.getName();
        this.address=requestDto.getAddress();
        this.age=requestDto.getAge();
        this.job=requestDto.getJob();
    }

}
