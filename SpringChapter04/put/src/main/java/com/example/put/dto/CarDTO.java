package com.example.put.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDTO {
    private String name;
    @JsonProperty("car_number")
    private String carNumber; //car_number

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
