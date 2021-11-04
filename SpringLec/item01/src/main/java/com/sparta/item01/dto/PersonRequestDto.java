package com.sparta.item01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PersonRequestDto {
    private String name;
    private String address;
    private int age;
    private String job;

    public PersonRequestDto(String name, String address, int age, String job) {
        this.name=name;
        this.address=address;
        this.age=age;
        this.job=job;
    }
}