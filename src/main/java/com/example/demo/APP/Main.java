package com.example.demo.APP;

import com.example.demo.APP.dequeue.deQueueEmail;
import com.example.demo.APP.dequeue.deQueueNotifications;
import com.example.demo.APP.dequeue.deQueueSMS;
import com.example.demo.APP.send.sendEmail;
import com.example.demo.APP.send.sendNotifications;
import com.example.demo.APP.send.sendSMS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static void menu() throws IOException, SQLException {
        Scanner inputs=new Scanner(System.in);
        Scanner input=new Scanner(System.in);

        System.out.println("1-send Notification");
        System.out.println("2-de-Queue Notification");
        String c;
        c=input.nextLine();
        if(c.equals("1"))
        {
            System.out.println("Welcome to Notification API");
            System.out.println("1-send  throw sms");
            System.out.println("2-send  throw Email");
            //public void add(@RequestParam int id,@RequestParam String placeholder,@RequestParam String sendType,@RequestParam int number)
            sendNotifications obj;
            String choice,placeholder,email,number,context;
            choice=input.nextLine();
            if (choice.equals("1"))
            {
                obj=new sendSMS();
                System.out.println("enter context\n");
                context=input.nextLine();
                System.out.println("Enter placeholder\n");
                placeholder=input.nextLine();
                System.out.println("Enter number\n");
                number=input.nextLine();
                obj.send(context,placeholder,"sms",number);

            }
            else if(choice.equals("2"))
            {
                obj=new sendEmail();
                System.out.println("enter context\n");
                context=input.nextLine();
                System.out.println("Enter placeholder\n");
                placeholder=input.nextLine();
                System.out.println("Enter email\n");
                email=input.nextLine();
                obj.send(context,placeholder,"mail",email);
            }
            else
            {
                menu();
            }

        }
        else if(c.equals("2"))
        {   deQueueNotifications ob;
            System.out.println("1-de-Queue SMS");
            System.out.println("2-de-Queue Email");
            c=input.nextLine();
            if(c.equals("1")){
                ob =new deQueueSMS();
                ob.deQueue();
            }
            else if(c.equals("2"))
            {
                ob=new deQueueEmail();
                ob.deQueue();
            }
            else
            {
                menu();
            }

        }
        else
        {
            menu();
        }

    }

    public static void main(String[] args) throws IOException, SQLException {
        menu();
    }
}

