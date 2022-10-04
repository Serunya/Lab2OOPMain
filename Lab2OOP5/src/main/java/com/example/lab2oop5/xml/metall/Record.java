package com.example.lab2oop5.xml.metall;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Record")
public class Record {
    @XmlAttribute(name = "Date")
    private String date;
    @XmlAttribute(name = "Code")
    private String code;
    @XmlElement(name = "Buy")
    private String price;

    public Record() {
    }

    public String getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public String getPrice() {
        return price;
    }
}
