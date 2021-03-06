package com.example.demo.APP.send;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class sendSMS implements sendNotifications{
    private static HttpURLConnection connection;
    private void connection(String urlValue) throws IOException {
        BufferedReader reader;
        String line;
        URL url=new URL(urlValue);

        connection= (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int status=connection.getResponseCode();
        connection.disconnect();
    }

    public void send(String context,String placeholder,String sendType,String number) throws IOException {

        String url="http://localhost:8080/api/notification/sendSMS?context="+context+"&placeholder="+placeholder+"&sendType=sms&number="+number;
        connection(url);
    }
}
