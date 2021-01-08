package com.example.demo.APP.send;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public interface sendNotifications {
   public void send(String context,String placeholder,String sendType,String number) throws IOException;

}
