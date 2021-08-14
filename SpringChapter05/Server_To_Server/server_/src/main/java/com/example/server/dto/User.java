package com.example.server.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//클라이언트와 dto 이름이 달라도 된다. 내용만 같으면된다.
//client : UserResponse, server: User ---> 상관 노노
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int age;
}
