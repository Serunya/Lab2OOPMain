package com.example.lab2oop5.xml.allval;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "ValCurs")
public class ValuteCurs {

    @XmlElement(name = "Valute")
    private ArrayList<Valute> valutes = new ArrayList<>();
    public ValuteCurs(){

    }

    public ArrayList<Valute> getValutes() {
        return valutes;
    }
}
