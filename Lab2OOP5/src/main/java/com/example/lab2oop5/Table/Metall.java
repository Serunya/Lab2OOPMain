package com.example.lab2oop5.Table;

import javafx.beans.property.SimpleStringProperty;

public class Metall {
    SimpleStringProperty name;
    SimpleStringProperty price;
    SimpleStringProperty date;
    public Metall(String code,String price, String date){
        switch (code){
            case("1") -> name = new SimpleStringProperty("Золото");
            case("2") -> name = new SimpleStringProperty("Серебро");
            case("3") -> name = new SimpleStringProperty("Платина");
            case("4") -> name = new SimpleStringProperty("Паладий");
        }
        this.price = new SimpleStringProperty(price);
        this.date = new SimpleStringProperty(date);
    }

    public String getName() {
        return name.get();
    }


    public void setName(String name) {
        this.name.set(name);
    }

    public String getPrice() {
        return price.get();
    }


    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
