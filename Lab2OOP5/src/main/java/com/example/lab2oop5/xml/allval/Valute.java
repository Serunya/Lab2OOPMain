package com.example.lab2oop5.xml.allval;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Valute")
public class Valute {
    @XmlElement(name = "NumCode")
    private String numCode;
    @XmlElement(name = "CharCode")
    private String CharCode;
    @XmlElement(name = "Nominal")
    private String Nominal;
    @XmlElement(name = "Name")
    private String Name;
    @XmlElement(name = "Value")
    private String Value;

    public Valute(){
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public String getValue() {
        return Value;
    }
}
