package com.example.demo.web;

import com.example.demo.Application.main;
import com.example.demo.core.NotificationTemplate;
import com.example.demo.core.notification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping  ("/api/notification/add")
@RestController
public class notificationController {
    private main service=new main();
    @PostMapping
    public void add(@RequestBody notification n)
    {
        service.addNotification(n);
    }
}
