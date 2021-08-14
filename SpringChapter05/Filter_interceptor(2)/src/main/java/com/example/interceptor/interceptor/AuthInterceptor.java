package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build().toUri();
        log.info("request url : {}" ,url);
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        //나의 서버는 모두 public으로 동작을 하는데
        //단, Auth 권한을 가진 요청을 대해서는 세션, 쿠키, 특정한 것을 보겠다.

        if (hasAnnotation){
            //권한 체크
            String query = uri.getQuery();
            if(query.equals("name=taehee")){
                return true;
            }
            throw new AuthException();
        }

        return true; //true가 되어야 인터셉터를 넘어서 안의 로직을 탄다.

    }

    private boolean checkAnnotation(Object handler, Class clazz){
        // resource, javascript, html, --> 무조건 통과
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }
        // 어노테이션이 달려있다
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(null != handlerMethod.getMethodAnnotation(clazz)|| null!= handlerMethod.getBeanType().getAnnotation(clazz)){
            //Auth annotation 이 있을 때는 True;
            return true;
        }
        return false;
    }
}
