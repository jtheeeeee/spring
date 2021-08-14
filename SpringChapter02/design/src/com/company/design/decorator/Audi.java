package com.company.design.decorator;

public class Audi implements Icar{
    private int price;

    public Audi(int price){
        this.price=price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("Audi의 가격은 "+this.price+"입니다");
    }
}
