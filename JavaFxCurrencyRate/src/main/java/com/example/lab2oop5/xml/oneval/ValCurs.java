package com.example.lab2oop5.xml.oneval;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "ValCurs")
public class ValCurs {
    @XmlAttribute(name = "ID")
    private String ID;
    @XmlAttribute(name = "DateRange1")
    private String DataRange1;
    @XmlAttribute(name = "DateRange2")
    private String DataRange2;
    @XmlAttribute
    private String name;

    @XmlElement(name = "Record")
    private ArrayList<Record> list = new ArrayList<>();

    public ValCurs() {
    }

    public ArrayList<Record> getList() {
        return list;
    }


}
