package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;

@Service
public class RestTemplateService {

    //http://localhost:8080/api/server/hello
    //response
    public UserResponse hello() {
        //uri 만드는 방법
        //get
       /* URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();*/
        //get에 데이터 보내기
        //http://localhost:9090/api/server/hello?name=steve&age=25
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "steve")
                .queryParam("age", 99)
                .encode()
                .build()
                .toUri();
        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
//          getForEntity --> Get방식이란 뜻
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
        return result.getBody();
    }

    //post방식
    /*public UserResponse post() {
        //http://localhost:9090/api/server/user/{userId}/name/{username}
        //1. 주소 만들기
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"taehee") //들어갈 값을들 expane()안에 ,로 구분해서 순서대로 넣어준다!
                .toUri();
        System.out.println(uri);
        //2. 보내고싶은 req 객체 만들고 (오브젝트로!, 왜냐면 오브젝트 맵퍼가 JSON으로 만들어주니까!)
        //http body 필요 --> Object로 보내면 --> Object Mapper가 json으로 바꿔서 rest template에서 http body에 json 으로 넣어줌
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        //3.restTemplate 에다가 넣어서 쏘면
        //3.response에 응답이 담기고,
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);
        //4. 출력
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }*/

    //header

    public void post() {
        //http://localhost:9090/api/server/user/{userId}/name/{username}
        //1. 주소 만들기
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"taehee") //들어갈 값을들 expane()안에 ,로 구분해서 순서대로 넣어준다!
                .toUri();
        System.out.println(uri);
        //2. 보내고싶은 req 객체 만들고 (오브젝트로!, 왜냐면 오브젝트 맵퍼가 JSON으로 만들어주니까!)
        //http body 필요 --> Object로 보내면 --> Object Mapper가 json으로 바꿔서 rest template에서 http body에 json 으로 넣어줌
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        //3.restTemplate 에다가 넣어서 쏘면
        //3.response에 응답이 담기고,
        RestTemplate restTemplate = new RestTemplate();
        //서버가 뭘 내려줄지 모르겠으니 일단 스트링으로 받겠다!
        ResponseEntity<String> response = restTemplate.postForEntity(uri, req, String.class);
        //4. 출력
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

//        return response.getBody();
    }


    //실제로 업무에서 사용할때는 헤더값들을 넣어서 쓴다.
    public UserResponse exchange(){

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"taehee")
                .toUri();
        System.out.println(uri);
        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        //응답을 보낼대는 requestEntity
        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
        return response.getBody();
    }

    public Req<UserResponse> gExchange(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"taehee")
                .toUri();
        System.out.println(uri);

        UserRequest userRequest = new UserRequest();
        userRequest.setName("steve");
        userRequest.setAge(10);

        Req<UserRequest> req = new Req<>();
        req.setHeader(
                new Req.Header()
        );
        req.setResponseBody(
                userRequest
        );

        //응답을 보낼대는 requestEntity
        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization","abcd")
                .header("custom-header","fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Req<UserResponse>>(){});
        return response.getBody();
    }


}
