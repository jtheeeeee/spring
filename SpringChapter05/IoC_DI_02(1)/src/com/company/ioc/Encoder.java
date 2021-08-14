package com.company.ioc;

import java.util.Base64;

public class Encoder  {

    private IEncoder iEncoder;
    //본질을 건드리는 방법
    //굉장히 비효율
    /*public Encoder(){
        //this.iEncoder = new Base64Encoder();
        this.iEncoder = new UrlEncoder();
    }
*/
    public Encoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }
    public String encode(String message){
        return iEncoder.encode(message);
    }
}
