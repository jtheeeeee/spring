package com.company.design.singleton;

public class SocketClient {

    // 자기 자신을 객체로 가지고 있어야한다.
    private static SocketClient socketClient=null;

    // 기본 생성자를 private
    private SocketClient(){}

    // static method를 통해 getInstance()를 제공해야함.
    // 자기 객체를 return
    public static SocketClient getInstance(){
        //객체가 null인지 아닌지 check해야함함
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }
    public void connect(){
        System.out.println("connect");
    }
}
