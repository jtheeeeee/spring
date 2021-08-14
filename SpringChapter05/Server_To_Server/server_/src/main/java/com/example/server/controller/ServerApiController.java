package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {
//https://openapi.naver.com/v1/search/local.json?
// query=%EC%84%9C%EC%9A%B8%EA%B0%88%EB%B9%84
// &display=10
// &start=1
// &sort=random
    @GetMapping("/naver")
    public String naver(){

        String query = "갈비집";
        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query","중국집")
                .queryParam("display",10)
                .queryParam("start",1)
                .queryParam("sort","random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id","02877vWYc5DWO3fxk0ax")
                .header("X-Naver-Client-Secret","SQD1ctOPDB").build();


        log.info("uri: {}",uri);
        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        return result.getBody();

    }


    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        //get으로 받아온 데이터 넣어주기!
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    /*@PostMapping("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorization,
                     @RequestHeader("custom-header") String customHeader ){
        log.info("userId : {}, userName :{}",userId, userName );
        log.info("authorization: {}, custom :{}",authorization, customHeader );

        log.info("client req : {}", user);
        return user;

    }*/

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
                    //HttpEntity<String> entity,
                    @RequestBody Req<User> user,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorization,
                     @RequestHeader("custom-header") String customHeader ){
        //log.info("req:{}", entity.getBody());
        log.info("userId : {}, userName :{}",userId, userName );
        log.info("authorization: {}, custom :{}",authorization, customHeader );

        log.info("client req : {}", user);

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setResponseBody(user.getResponseBody());

        return response;

    }
}
