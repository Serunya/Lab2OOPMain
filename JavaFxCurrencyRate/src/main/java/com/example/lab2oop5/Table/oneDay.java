package com.example.lab2oop5.Table;

import javafx.beans.property.SimpleStringProperty;

public class oneDay {
    private SimpleStringProperty date;
    private SimpleStringProperty nominal;

    public oneDay(String date, String nominal) {
        this.date = new SimpleStringProperty(date);
        this.nominal = new SimpleStringProperty(nominal);
    }

    public String getDate() {
        return date.get();
    }

    public String getNominal() {
        return nominal.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setNominal(String nominal) {
        this.nominal.set(nominal);
    }
}
