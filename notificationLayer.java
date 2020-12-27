package com.example.demo.infrastructure;

import com.example.demo.connection.Database;
import com.example.demo.core.NotificationTemplate;
import com.example.demo.core.notification;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class notificationLayer {

    List<notification> allNotifications=new ArrayList<notification>();
    TemplateDataAccessLayer obj=new MemoryDataAccessLayer();
    String query ="";
    private void queuing()
    {

            addNotification(allNotifications.get(allNotifications.size()-1));
    }
    private boolean addNotification(notification notify)
    {
        boolean added = false;
        try{
            Connection con= Database.getConnection();
            Statement stmt = con.createStatement();
            if(notify.sendType.equals("sms"))
            {
                 query = "INSERT INTO smsNotification(tempID,subject,content,number) VALUES("
                        + "'" + notify.id + "',"
                        + "'" + notify.subject + "',"
                        + "'" + notify.content+ "',"
                        + "'" + notify.number  + "')";
                added = true;
                stmt.executeUpdate(query);
            }
            else if(notify.sendType.equals("mail"))
            {   query = "INSERT INTO emailNotification(tempID,subject,content,email) VALUES("
                    + "'" + notify.id + "',"
                    + "'" + notify.subject + "',"
                    + "'" + notify.content+ "',"
                    + "'" + notify.email  + "')";

                    added = true;
                stmt.executeUpdate(query);
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        return added;
    }
    public boolean createNotification(notification notifi)
    {
        int templateID=notifi.id; String x=notifi.placeholder;

        NotificationTemplate  tempTemplate = obj.searchTemplates(templateID);
        if(tempTemplate != null)
        {
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
