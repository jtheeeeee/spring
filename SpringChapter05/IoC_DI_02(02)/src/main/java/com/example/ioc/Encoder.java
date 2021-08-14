package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Encoder  {

    private IEncoder iEncoder;

    //컴포넌트에 이름을 지어주지 않았으면 클래스의 맨 앞글자를 소문자로 만든 이름을 넣어준다.
    //@Component("~") 이런식으로 ~안에 이름을 지정이름을 넣어줘도 된다.
    /*public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }*/

    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    //빈을 주입받을 수 있는 곳: 변수, 생성자, set메서드

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder=iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
