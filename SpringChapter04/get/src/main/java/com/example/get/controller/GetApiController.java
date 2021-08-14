package com.example.get.controller;



import com.example.get.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //현재 코딩하는 방식
    @GetMapping(path="/hello") //h ttp://localhost/8080/api/get/hello
    public String hello(){
        return "get hello";
    }

    //옛날 방식
    //get http://localhost:8080/api/get/hi
    //get메서드로 동작
    @RequestMapping(value = "/hi",method = RequestMethod.GET) //get, post, put, delete get외에 모든 메서드가 다 동작하게 된다.
    public String hi(){         //그래서 get메서드만 사용하고 싶을때 method= 히고 명시해주어야 한다.
        return "hi";
    }

    //http://localshot:8080//api/get/path-variable/{name} (주소에대문자안씀)
    //변화하는 것들을 받는다. 이름, 나이 등등 name자리가 변한다.
    //변화하는 것이 생길때마다 주소를 추가할 수는 없다.
    //바뀌는 부분에 {}를 쓰고 안에 무엇을 받을지 변수명을 쓴다.
    //매개변수로 어노테이션을 사용해서 받아준다.
    //http://localhost:8080/api/get/path-variable/java ==> java 리턴
    //변수명을 똑같이 맞춰주어야한다.
    //{} 안에 변수명이 맵핑시켜주는 것 외에, 다른 매개변수로 사용해야할 경우
    //@PathVariable(name ="") 을 사용하여 {} 안에 있는 변수와 "" 안에 있는 변수명을 맞추주면된다. 어렵네,,
    //(name ="") 안쓰고 그냥 맞춰주도 되긴함,,
    @GetMapping("/path-variable/{name2}")
    public String pathVariable(@PathVariable(name="name2") String pathName){
        System.out.println("PathVariable :"+pathName);
        return pathName;
    }
    //url쪼개보기
    // search?q = intelliJ
    // &oq = intelliJ
    // &aqs = chrome..69i57j35i39l2j0i512l2j69i61l2j69i60.5626j0j9
    // &sourceid = chrome
    // &ie = UTF-8
    // ?key=value&key2=value2
    //http://localhost:8080/api/get/query-param?user =steve&email=steve@gmail.com&age=30

    //@QueryParam 어노테이션을 써야한다.
    // 이 경우는 어떤 key를 받을지 특정하지 않았다.
    @GetMapping(path="query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // 쿼리 파라미터로 어떤 키를 받을ㅈ 정하기 위해서는 아래와 같이 한다.
    // 변수가 많아지면 문제가된다. -> 스프링에서는 DTO를 만들어서 사용한다. 현업에서 가장 많이 사용하는 방법
    @GetMapping("query-param02")
    public String queryParam02( @RequestParam String name, @RequestParam String email, @RequestParam int age){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name +" "+email+" "+ age;
        //age에 문자열 넣으면 에러남.
    }

    //3번쨰 방법, dto 사용, 현업에서 많이 사용
    //@RequestParam 어노테이션은 붙이지 않는다.
    //스프링 부트에서는 객체가 들어오게되면
    //url에 있는 key 와 value를 dto에서 찾아서 매칭 시킨다.
    //요청하는 값에 대한 검증을 할때도 객체를 활용할때 편하다.
    //쿼리파라미터로 받는 객체가 적거나, 무엇이 들어올지 모를때는 1이나 2도 써도되지만
    //3번이 가장 많이 쓰인다구 한다,,,,,

    @GetMapping("query-param03")
    public String queryParam02(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
        //age에 문자열 넣으면 에러남.
    }
}
