package com.example.lab2oop5.xml.oneval;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Record")
public class Record {
    @XmlAttribute(name = "Date")
    private String Data;
    @XmlAttribute(name = "Id")
    private String Id;

    @XmlElement
    private String Nominal;
    @XmlElement
    private String Value;

    public String getData() {
        return Data;
    }

    public String getValue() {
        return Value;
    }
}
