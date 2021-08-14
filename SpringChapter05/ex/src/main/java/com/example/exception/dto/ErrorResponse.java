package com.example.exception.dto;

import java.util.List;

public class ErrorResponse {

    String statueCode;
    String requestUrl;
    String code;
    String messagel;
    String resultCode;

    List<Error> errorList;

    public String getStatueCode() {
        return statueCode;
    }

    public void setStatueCode(String statueCode) {
        this.statueCode = statueCode;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessagel() {
        return messagel;
    }

    public void setMessagel(String messagel) {
        this.messagel = messagel;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }
}
