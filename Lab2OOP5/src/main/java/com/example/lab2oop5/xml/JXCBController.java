package com.example.lab2oop5.xml;

import com.example.lab2oop5.xml.allval.ValuteCurs;
import com.example.lab2oop5.xml.oneval.ValCurs;
import com.example.lab2oop5.xml.valcode.Item;
import com.example.lab2oop5.xml.valcode.Valuta;
import com.example.lab2oop5.xml.oneval.Record;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class   JXCBController {


    public static ValuteCurs getOneDay(LocalDate firstDate){
        String date = NormalizeData(firstDate);
        String url = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=20/08/2021";
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            JAXBContext context = JAXBContext.newInstance(ValuteCurs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (ValuteCurs) unmarshaller.unmarshal(con.getInputStream());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Valuta getAllValute(InputStream inputStream){
        try {
            JAXBContext context = JAXBContext.newInstance(Valuta.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return  (Valuta) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String NormalizeData(LocalDate firstDate){
        String Date1;
        Integer day = firstDate.getDayOfMonth();
        Integer month = firstDate.getMonthValue();
        if(day < 10){
            Date1 = "0" + day;
        }else{
            Date1 = "" + day;
        }
        if(month < 10){
            Date1 += "/0" + month;
        }else{
            Date1 += "/" + month;
        }
        return Date1 += "/" + firstDate.getYear();
    }

    public static ValCurs getOneVal(LocalDate firstDate, LocalDate secondDate,String code){
        String Date1 = NormalizeData(firstDate);
        String Date2 = NormalizeData(secondDate);
        try {
            String url  = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1="+Date1+"&date_req2="+Date2+"&VAL_NM_RQ="+code;
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            JAXBContext context = JAXBContext.newInstance(ValCurs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (ValCurs) unmarshaller.unmarshal(con.getInputStream());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL("http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=01/09/2022&date_req2=01/10/2022&VAL_NM_RQ=R01010").openConnection();
            InputStream is = con.getInputStream();
            JAXBContext context = JAXBContext.newInstance(ValCurs.class);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String l;
            while((l = bf.readLine()) != null){
                System.out.println(l);
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
