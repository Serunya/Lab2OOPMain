package com.example.lab2oop5.xml.metall;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Metall")
public class Metall {

    @XmlElement(name = "Record")
    private ArrayList<Record> mettals = new ArrayList<>();

    public ArrayList<Record> getMettals() {
        return mettals;
    }

    public Metall() {
    }
}
