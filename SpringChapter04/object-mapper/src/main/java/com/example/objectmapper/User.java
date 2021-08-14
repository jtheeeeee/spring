package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User  {
    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User(){
        this.name = null;
        this.age = 0;
        this.phoneNumber=null;

    }

    /*  object mapper를 사용할 때는 메서드 명에 get이 들어가는 것을 조심해야한다,,,,
    public User getDefaultUser(){
        return new User("default", 0);
    }
    */

    public User defaultUser(){
        return new User("default", 0, "010-0000-0000");
    }

    public User(String name, int age,String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
