package com.example.lab2oop5.xml.valcode;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlAttribute(name = "ID")
    private String ID;

    @XmlElement
    private String Name;
    @XmlElement
    private String EngName;
    @XmlElement
    private String Nominal;
    @XmlElement
    private String ParentCode;

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEngName() {
        return EngName;
    }

    public String getParentCode() {
        return ParentCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return Name;
    }
}
