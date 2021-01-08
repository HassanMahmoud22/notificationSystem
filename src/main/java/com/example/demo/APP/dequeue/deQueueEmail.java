package com.example.demo.APP.dequeue;

import com.example.demo.connection.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class deQueueEmail implements deQueueNotifications{
    public void deQueue() throws SQLException {
        String query;
        Connection con= Database.getConnection();
        Statement stmt = con.createStatement();
        query="select count(*) from emailnotification";
        ResultSet RS = stmt.executeQuery("select count(*) from emailnotification");
        RS.next();
        int count= RS.getInt(1);


        for (int i = 0; i <count ; i++) {
            RS = stmt.executeQuery("select  subject,content,email,status from emailnotification ORDER BY id DESC LIMIT 1");
            while (RS.next())
            {
                System.out.println(i+1+":-");
                System.out.println("subject :"+RS.getString("subject"));
                System.out.println("content :"+RS.getString("content"));
                System.out.println("email :"+RS.getString("email"));
                System.out.println("status :"+RS.getString("status"));
                System.out.println("Removed");

            }
            query="delete from emailnotification order by id desc limit 1";
            stmt.executeUpdate(query);
        }
    }

}
