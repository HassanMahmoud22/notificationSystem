package com.example.demo.Application;

import com.example.demo.core.NotificationTemplate;
import com.example.demo.core.notification;
import com.example.demo.infrastructure.TemplateDataAccessLayer;
import com.example.demo.infrastructure.MemoryDataAccessLayer;
import com.example.demo.infrastructure.notificationLayer;

public class main {
    TemplateDataAccessLayer repo=new MemoryDataAccessLayer();
    notificationLayer obj=new notificationLayer();
    public void add(NotificationTemplate temp)
    {
        repo.addTemplate(temp);

    }
    public NotificationTemplate read(int tempID)
    {
        return repo.getTemplate(tempID);
    }

    public void delete(int tempID)
    {
        repo.deleteTemplate(tempID);
    }

    public void update(NotificationTemplate temp)
    {
        System.err.println(temp.content);
        repo.updateTemplate(temp);
    }

    public void  addNotification(notification n)
    {
        obj.createNotification(n);
    }

}
