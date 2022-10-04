package com.example.lab2oop5.xml.valcode;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;


@XmlRootElement(name = "Valuta")
public class Valuta {

    @XmlAttribute(name="name")
    private String Name;

    @XmlElement(name = "Item")
    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    public Valuta() {
    }
}
