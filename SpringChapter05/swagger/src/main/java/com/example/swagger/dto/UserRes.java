package com.example.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRes {
    @ApiModelProperty(value="사용자의 이름", example = "steve",required = true)
    private String name;
    @ApiModelProperty(value="사용자의 나이", example = "25",required = true)
    private int age;
    
}
