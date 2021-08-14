package com.example.interceptor.config;

import com.example.interceptor.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPattern  이걸 등록해주면 어노테이션을 타지 않아도 겁사한다.
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
        //다른 인터셉터를 넣을 수도 있다,, ;ㅡ;,,,
    }
}
