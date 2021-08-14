package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        //Text JSON --> Object
        //Object --> Text JSON

        //controller req json(text) --> object
        //response object --> json(text)

        var objectMapper = new ObjectMapper();

        //object --> text
        //object mapper는 get method를 활용한다.
        //getter를 만들어 주어야 한다.
        var user = new User("태희",25,"010-8828-5983");

        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        //text --> object
        //default 생성자가 필요하다.
        //obejct mapper 는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
