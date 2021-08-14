package com.example.vaildation.dto;

import com.example.vaildation.annotation.YearMonth;
import jdk.jfr.Experimental;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class User {
    @NotBlank // null, 띄어쓰기, 필수적
    private String name;
    @Max(value = 90)
    private int age;
    /*@Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;

    //@Size(min=6, max=6)
    @YearMonth()
    private String reqYearMonth; // yyyymm*/

    @Valid // 오브젝트 형태일때, 검사하고 싶으면 Valid를 꼭 넣어줘야한대.. controller User한테도 붙어있더라..까먹지 말자.
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

 /*   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }
*/
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }

    //Assert True는 한정적인 클래스 내에서만 쓸수 있다.
    //하지만 커스텀 어노테이션을 만들면 다른 dto를 만들어도 적용가능하다!
    //멋있는데?
    //boolean 형식 메서드의 이름은 is 키워드가 들어가야한다.
    /*@AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다. ")
    public boolean isReqYearMonthValidation(){
        System.out.println("assert true call");

        try {
            LocalDate localDate = LocalDate.parse(getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        }catch (Exception e){
            return false;
        }

        return true;
    }*/


}


