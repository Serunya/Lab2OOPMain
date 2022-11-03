package com.example.lab2oop5;

import com.example.lab2oop5.Table.Metall;
import com.example.lab2oop5.Table.ValuteTableColumn;
import com.example.lab2oop5.Table.oneDay;
import com.example.lab2oop5.xml.allval.Valute;
import com.example.lab2oop5.xml.allval.ValuteCurs;
import com.example.lab2oop5.xml.oneval.Record;
import com.example.lab2oop5.xml.oneval.ValCurs;
import com.example.lab2oop5.xml.valcode.Item;
import com.example.lab2oop5.xml.JXCBController;
import com.example.lab2oop5.xml.valcode.Valuta;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Controller {

    public ComboBox<String> typeRequest;
    public ComboBox<Item> typeVal;
    public DatePicker firstData;
    public DatePicker secondData;
    public LineChart<String,Number> lineChart;
    public TableView table;

    public void initialize() {
        typeRequest.getItems().add("Один день");
        typeRequest.getItems().add("Диапозон дат");
        typeRequest.getItems().add("Металлы");
        typeRequest.setValue("Диапозон дат");
        typeRequest.getSelectionModel().selectedItemProperty().addListener((opt, oldValue, newValue) -> {
            if (newValue.equals("Диапозон дат") || newValue.equals("Металлы")) {
                typeVal.setVisible(true);
                secondData.setVisible(true);
                lineChart.setVisible(true);
                table.setMinWidth(350);
            }
            if (newValue.equals("Один день")) {
                typeVal.setVisible(false);
                secondData.setVisible(false);
                lineChart.setVisible(false);
                table.setMinWidth(850);
            }
        });
        fillComboBoxValute();
    }

    private void fillComboBoxValute(){
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://cbr.ru/scripts/XML_val.asp?d=0").openConnection();
            Valuta val = JXCBController.getAllValute(connection.getInputStream());
            assert val != null;
            for(Item i: val.getItems())
                typeVal.getItems().add(i);
            typeVal.setValue(val.getItems().get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getData(){
        table.getItems().clear();
        table.getColumns().clear();
        lineChart.getData().clear();
        if(typeRequest.getValue().equals("Диапозон дат")){
            TableColumn<oneDay,String> date = new TableColumn<>("Дата");
            date.setCellValueFactory(new PropertyValueFactory<oneDay, String>("date"));
            TableColumn<oneDay,String> nominal = new TableColumn<>("Номинал");
            nominal.setCellValueFactory(new PropertyValueFactory<oneDay,String>("nominal"));
            table.getColumns().add(date);
            table.getColumns().add(nominal);
            ValCurs val = JXCBController.getOneVal(firstData.getValue(),secondData.getValue(),typeVal.getValue().getID());
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(typeVal.getValue().getName());
            for(Record r: val.getList()){
                series.getData().add(new XYChart.Data<>(r.getData(),Double.parseDouble(r.getValue().replace(',','.'))));
                table.getItems().add(new oneDay(r.getData(),r.getValue()));
            }
            lineChart.getData().addAll(series);
        }
        if(typeRequest.getValue().equals("Один день")){
            TableColumn<ValuteTableColumn,String> numCode = new TableColumn<>("NumCode");
            TableColumn<ValuteTableColumn,String> charCode = new TableColumn<>("CharCode");
            TableColumn<ValuteTableColumn,String> nominal = new TableColumn<>("Номинал");
            TableColumn<ValuteTableColumn,String> name = new TableColumn<>("Имя");
            TableColumn<ValuteTableColumn,String> value = new TableColumn<>("Значение");

            numCode.setCellValueFactory(new PropertyValueFactory<ValuteTableColumn,String>("NumCode"));
            charCode.setCellValueFactory(new PropertyValueFactory<ValuteTableColumn,String>("CharCode"));
            nominal.setCellValueFactory(new PropertyValueFactory<ValuteTableColumn,String>("Nominal"));
            name.setCellValueFactory(new PropertyValueFactory<ValuteTableColumn,String>("Name"));
            value.setCellValueFactory(new PropertyValueFactory<ValuteTableColumn,String>("Value"));
            table.getColumns().add(numCode);
            table.getColumns().add(charCode);
            table.getColumns().add(nominal);
            table.getColumns().add(name);
            table.getColumns().add(value);
            ValuteCurs val = JXCBController.getOneDay(firstData.getValue());
            assert val != null;
            for(Valute v: val.getValutes()){
                table.getItems().add(new ValuteTableColumn(v.getNumCode(),v.getCharCode(),v.getNominal(),v.getName(),v.getValue()));
            }
        }

        if(typeRequest.getValue().equals("Металлы")){
            com.example.lab2oop5.xml.metall.Metall metall = JXCBController.getMettals(firstData.getValue(),secondData.getValue());
            TableColumn<Metall,String> name = new TableColumn<>("Металл");
            TableColumn<Metall,String> price = new TableColumn<>("Цена");
            TableColumn<Metall,String> date = new TableColumn<>("Дата");
            name.setCellValueFactory(new PropertyValueFactory<Metall,String>("name"));
            price.setCellValueFactory(new PropertyValueFactory<Metall,String>("price"));
            date.setCellValueFactory(new PropertyValueFactory<Metall,String>("date"));
            table.getColumns().add(name);
            table.getColumns().add(price);
            table.getColumns().add(date);
            XYChart.Series<String, Number> series1 = new XYChart.Series<>();
            XYChart.Series<String, Number> series2 = new XYChart.Series<>();
            XYChart.Series<String, Number> series3 = new XYChart.Series<>();
            XYChart.Series<String, Number> series4 = new XYChart.Series<>();
            series1.setName("Золото");
            series2.setName("Серебро");
            series3.setName("Платина");
            series4.setName("Паладий");
            for(com.example.lab2oop5.xml.metall.Record r: metall.getMettals()){
                   table.getItems().add(new Metall(r.getCode(),r.getPrice(),r.getDate()));
                   double priceS = Double.parseDouble(r.getPrice().replace(',','.'));
                   switch (r.getCode()){
                       case("1")->{
                           series1.getData().add(new XYChart.Data<>(r.getDate(),priceS));
                       }
                       case("2")->{
                           series2.getData().add(new XYChart.Data<>(r.getDate(),priceS));
                       }
                       case("3")-> series3.getData().add(new XYChart.Data<>(r.getDate(),priceS));
                       case("4")->{series4.getData().add(new XYChart.Data<>(r.getDate(),priceS));}
                   }
                   lineChart.getData().add(series1);
                   lineChart.getData().add(series2);
                   lineChart.getData().add(series3);
                   lineChart.getData().add(series4);
            }

        }
    }


}