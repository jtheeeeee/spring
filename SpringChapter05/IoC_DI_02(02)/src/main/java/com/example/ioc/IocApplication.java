package com.example.ioc;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Component 어노테이션이 붙은 객체를
//스프링이 실행될때 싱글톤으로 만들어서, 스프링 컨테이너에서 관리
@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {

        SpringApplication.run(IocApplication.class, args);

        ApplicationContext context =  ApplicationContextProvider.getContext();
        // 서비스로직에서는 컨텍스트를 통해서 가져온다.
        // 스프링에서 객체를 직접 관리하는거,,
        // 스프링 빈들이 관리되는 것: 스프링 컨테이너
        // 스프링 컨테이너가 관리하기 때문에 IoC이다.


        //빈을 찾는 방법, 이름 or class type

        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        //Encoder encoder = new Encoder(base64Encoder);
        //Encoder encoder = context.getBean(Encoder.class);
        Encoder encoder = context.getBean("urlEncode",Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=10&name=spring-book";
        String result = encoder.encode(url);
        System.out.println(result);
/*
        encoder.setIEncoder(urlEncoder);
        result=encoder.encode(url);
        System.out.println(result);*/
    }

}

@Configuration //여러개의 빈을 등록할거야
class AppConfig{
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode") //urlEncoder가 이미 있기 때문에, 충돌이 날 수 있어 이름을 바꿔준다.
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}
