package com.example.demo.infrastructure;

import com.example.demo.connection.Database;
import com.example.demo.core.notification;
import java.sql.Connection;
import java.sql.Statement;

public class smsNotification extends notificationLayer {

    String query = "";

	public smsNotification(){};
	
	public boolean addNotification(notification notify)
    {
        boolean added = false;
        try{
            Connection con= Database.getConnection();
            Statement stmt = con.createStatement();
            if(notify.number.length()!=11)
            {
            	query = "INSERT INTO smsNotification(context,subject,content,status,number) VALUES("
                            + "'" + notify.context + "',"
                            + "'" + notify.subject + "',"
                            + "'" + notify.content+ "',"
                            + "'" +"failed"+ "',"
                            + "'" + notify.number  + "')";
                    added = true;
                    stmt.executeUpdate(query);
            }
            else
            {
            	query = "INSERT INTO smsNotification(context,subject,content,status,number) VALUES("
                            + "'" + notify.context + "',"
                            + "'" + notify.subject + "',"
                            + "'" + notify.content+ "',"
                            + "'" +"success"+ "',"
                            + "'" + notify.number  + "')";
                added = true;
                stmt.executeUpdate(query);
                // deQueueSMS();
           }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return added;
    }
	
	

}
