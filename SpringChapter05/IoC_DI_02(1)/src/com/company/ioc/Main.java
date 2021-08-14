package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=10&name=spring-book";

      /*  //Base 64 encoding
        Base64Encoder base64Encoder = new Base64Encoder();
        String result = base64Encoder.encode(url);

        //url encoding
        UrlEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);*/

        //아무생각 없이 만듦녀 인코더를 만들때 계속 만들어내면 된다.
        //하지만 그럴 수 없으니까 공통적인 걸 뽑아보자!
        //interface encoder(String message) --> 공통

        //크게 달라진 것 없음.
        /*IEncoder base64Encoder = new Base64Encoder();
        String result = base64Encoder.encode(url);
        IEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);
        System.out.println(urlResult);
        System.out.println(result);*/

        //테스트할때 원하는 객체만 바꿔주면 된다.DI개념
        //안쪽 내부 코드는 건드리지 않아도 된다.
        //DI는 되지만 여전히 객체를 내가 만들고있다.
        //IoC는 객체를 내가 만들지 않는다.
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
