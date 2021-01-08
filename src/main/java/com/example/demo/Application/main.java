package com.example.demo.Application;

import com.example.demo.core.NotificationTemplate;
import com.example.demo.core.notification;
import com.example.demo.infrastructure.*;

public class main {
    TemplateDataAccessLayer repo=new MemoryDataAccessLayer();
    notificationLayer obj;
    public void add(NotificationTemplate temp)
    {
        repo.addTemplate(temp);

    }
    public NotificationTemplate read(String context)
    {
        return repo.getTemplate(context);
    }

    public void delete(String context)
    {
        repo.deleteTemplate(context);
    }

    public void update(NotificationTemplate temp)
    {
        System.err.println(temp.content);
        repo.updateTemplate(temp);
    }

    public void  addNotification(notification n)
    {
        if(n.sendType.equals("sms"))
        {
            obj=new smsNotification();
            obj.createNotification(n);
        }
        else
        {
            obj=new emailNotification();
            obj.createNotification(n);
        }

    }

}
