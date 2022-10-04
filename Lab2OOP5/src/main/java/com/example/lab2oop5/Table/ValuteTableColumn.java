package com.example.lab2oop5.Table;

import javafx.beans.property.SimpleStringProperty;

public class ValuteTableColumn {
    SimpleStringProperty NumCode;
    SimpleStringProperty CharCode;
    SimpleStringProperty Nominal;
    SimpleStringProperty Name;
    SimpleStringProperty Value;

    public ValuteTableColumn(String numCode, String charCode, String nominal, String name, String value) {
        NumCode = new SimpleStringProperty(numCode);
        CharCode = new SimpleStringProperty(charCode);
        Nominal = new SimpleStringProperty(nominal);
        Name = new SimpleStringProperty(name);
        Value = new SimpleStringProperty(value);
    }

    public void setNumCode(String numCode) {
        this.NumCode.set(numCode);
    }

    public void setCharCode(String charCode) {
        this.CharCode.set(charCode);
    }

    public void setNominal(String nominal) {
        this.Nominal.set(nominal);
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public void setValue(String value) {
        this.Value.set(value);
    }

    public String getNumCode() {
        return NumCode.get();
    }

    public SimpleStringProperty numCodeProperty() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode.get();
    }

    public SimpleStringProperty charCodeProperty() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal.get();
    }

    public SimpleStringProperty nominalProperty() {
        return Nominal;
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public String getValue() {
        return Value.get();
    }

    public SimpleStringProperty valueProperty() {
        return Value;
    }
}
