package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@Service
public class AsyncService  {
    //같은 클래스 내의 같은 메서드를 호출할때는 async를 타지 않는다.
    //스프링 웹 mvc를 쓰는게 좋다,,
    //RDB에서는 async 의미가 없다.
    //WebFlux 공부해보자자
    @Async("async-thread") //public에만 붙을 수 있다.
    public CompletableFuture run(){
        return new AsyncResult(hello()).completable();
    }


    public String hello() {
        for(int i =0; i<10; i++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async hello";
    }
}
