package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
//@Component  --> 하나에만 적용시킬때
@WebFilter(urlPatterns = "/api/user/*") // --> 여러개 apiController중 선택적으로 적용시킬때
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //필터에서 들어온 내용을 모두 읽어버려서
        //api에서 읽을 수 있는 스트림이 남아있지 않아서 오류가 나게 된다.
        //전처리 구간
       /* HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse =(HttpServletResponse) response;
        String url = httpServletRequest.getRequestURI();
        BufferedReader br = httpServletRequest.getReader();
        br.lines().forEach(line -> {
            log.info("url :{},line:{}",url, line);

        });*/
        ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        /*BufferedReader br = contentCachingRequestWrapper.getReader();
        br.lines().forEach(line -> {
            log.info("url :{},line:{}",url, line);

        });*/

        //이걸 기준으로 위에가 전처리 아래가 후처리
        chain.doFilter(contentCachingRequestWrapper, contentCachingResponseWrapper);
        String url = contentCachingRequestWrapper.getRequestURI();

        //후처리구간
        String reqContent = new String(contentCachingRequestWrapper.getContentAsByteArray());

        log.info("request url : {}, requestBody : {}", url, reqContent);


        String resContent = new String(contentCachingResponseWrapper.getContentAsByteArray());
        int httpStatusCode = contentCachingResponseWrapper.getStatus();
        contentCachingResponseWrapper.copyBodyToResponse();

        log.info("response status : {}, responseBody : {}",httpStatusCode, resContent);

    }
}
