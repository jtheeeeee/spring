package com.example.filter.dto;

import lombok.*;

@Data  //몽땅 만들어줘,, 쩔어,,!,,
//@Getter //게터 만들어줌,,
//@Setter //세터 만들어줌,,
@NoArgsConstructor //기본 생성자 만들어줌,,
@AllArgsConstructor //있는 요소 다 들어간 생성자 만들어줌,,
public class User {

    private String name;
    private int age;


}
