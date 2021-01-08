package com.example.demo.web;

import com.example.demo.Application.main;
import com.example.demo.core.NotificationTemplate;
import com.example.demo.core.notification;
import org.springframework.web.bind.annotation.*;

@RestController
public class notificationController  {
    private main service=new main();
    @GetMapping("/api/notification/sendSMS")
    public void addSMS(@RequestParam String context, @RequestParam String placeholder, @RequestParam String sendType, @RequestParam String number)
    {

        notification n = new notification();
        n.context = context;
        n.placeholder = placeholder;
        n.sendType = sendType;
        n.number = number;
        service.addNotification(n);
    }
    @GetMapping("/api/notification/sendEmail")
    public void addEmail(@RequestParam String context, @RequestParam String placeholder,@RequestParam String sendType,@RequestParam String email)
    {
        notification n = new notification();
        n.context = context;
        n.placeholder = placeholder;
        n.sendType = sendType;
        n.email = email;
        service.addNotification(n);
    }


}