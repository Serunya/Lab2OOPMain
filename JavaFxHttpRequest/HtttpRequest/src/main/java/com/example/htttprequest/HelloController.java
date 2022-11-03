package com.example.htttprequest;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import static org.apache.http.protocol.HTTP.USER_AGENT;


public class HelloController {
    @FXML
    public TextField name1;
    public TextField name2;
    public TextField name3;
    public TextField name4;
    public TextField name5;
    public TextField name6;
    public TextField name7;

    @FXML
    public TextField value1;
    public TextField value2;
    public TextField value3;
    public TextField value4;
    public TextField value5;
    public TextField value6;
    public TextField value7;
    public TextArea ResponseArea;

    public void initialize(){
        ResponseArea.setEditable(false);
    }

    @FXML
    private ToggleButton getButton;
    @FXML
    private ToggleButton postButton;

    public void sendRequest() throws IOException {
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>(2);
        String url = "http://localhost:8080/Lab2_OOP_war/requestServlet";
        HttpURLConnection con = null;
        params.add(new BasicNameValuePair(name1.getText(), value1.getText()));
        params.add(new BasicNameValuePair(name2.getText(), value2.getText()));
        params.add(new BasicNameValuePair(name3.getText(), value3.getText()));
        params.add(new BasicNameValuePair(name4.getText(), value4.getText()));
        params.add(new BasicNameValuePair(name5.getText(), value5.getText()));
        params.add(new BasicNameValuePair(name6.getText(), value6.getText()));
        params.add(new BasicNameValuePair(name7.getText(), value7.getText()));
        String paramsString = toGetRequest(params);
        if (getButton.isSelected()) {
            url += "?" + paramsString;
            con = (HttpURLConnection) new URL(url).openConnection();
        } else {
            con = (HttpURLConnection) new URL(url).openConnection();
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(paramsString);
            wr.flush();
            wr.close();
        }
        assert con != null;
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        response.append("HTTP/ ").append(responseCode).append("\n");
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine).append('\n');
        }
        in.close();
        ResponseArea.setText(response.toString());
    }

    private String toGetRequest(ArrayList<NameValuePair> params) {
        StringBuilder dparams = new StringBuilder();
        for (NameValuePair param : params) {
            dparams.append(param).append("&");
        }
        return dparams.toString();
    }
}