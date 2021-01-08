package com.example.demo.infrastructure;

import com.example.demo.core.NotificationTemplate;
import com.example.demo.core.notification;

import java.util.ArrayList;
import java.util.List;

public abstract class notificationLayer {

    List<notification> allNotifications=new ArrayList<notification>();
    TemplateDataAccessLayer obj=new MemoryDataAccessLayer();

    private void queuing()
    {
        addNotification(allNotifications.get(allNotifications.size()-1));
    }

    protected abstract boolean addNotification(notification notify) ;

    public boolean createNotification(notification notifi)
    {
        System.err.println(notifi.context);
        String context=notifi.context; String x=notifi.placeholder;

        NotificationTemplate  tempTemplate = obj.searchTemplates(context);
        if(tempTemplate != null)
        {
            System.err.println(   tempTemplate.content+"  "+   tempTemplate.subject);
            notifi.subject = tempTemplate.subject;;
            String content = tempTemplate.content;
            content = content.replaceAll("\\{x\\}", x);
            notifi.content = content;
            allNotifications.add(notifi);
            queuing();
            return true;
        }
        return false;
    }

}



