package com.example.carbookingsystem.model;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class Car {

    private String id;

    private String type;
    private int count;

    //the price of renting car per day
    private double price;

    public Car() {
    }

    public Car(String id, String type, int count, double price) {
        this.id = id;
        this.type = type;
        this.count = count;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
