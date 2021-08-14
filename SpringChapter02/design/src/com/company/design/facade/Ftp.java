package com.company.design.facade;


public class Ftp {

    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path){
        this.host=host;
        this.port=port;
        this.path=path;
    }

    public void connet(){
        System.out.println("FTP host : "+host+" Port : "+port);
    }

    public void moveDirectory(){
        System.out.println("path : "+path);
    }

    public void disconnect(){
        System.out.println("FTP연결을 종료합니다. ");
    }
}
