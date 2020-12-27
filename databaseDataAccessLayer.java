package com.example.demo.infrastructure;

import com.example.demo.connection.Database;
import com.example.demo.core.NotificationTemplate;
import com.example.demo.core.languageEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class databaseDataAccessLayer  implements TemplateDataAccessLayer{
    Scanner stringInput = new Scanner(System.in);
    Scanner intInput = new Scanner(System.in);
    NotificationTemplate tempTemplate = new NotificationTemplate();
    String query = "";

    public boolean addTemplate(NotificationTemplate template)
    {

        try{

            Connection con= Database.getConnection();
            Statement stmt = con.createStatement();
            String line = "INSERT INTO templateTable(tempID,subject,content,language) VALUES("
                    + "'" + template.id  + "',"
                    + "'" + template.subject + "',"
                    + "'" + template.content + "',"
                    + "'" +template.language  + "')";
              stmt.executeUpdate(line);
                return true;

        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }

    }

    public boolean deleteTemplate(int templateID) {
        try{
            Connection con= Database.getConnection();
             Statement stmt = con.createStatement();
            tempTemplate = searchTemplates(templateID);
            if(tempTemplate != null)
            {
                query = "DELETE FROM templateTable WHERE tempID = '" + templateID + "'";
                stmt.executeUpdate(query);
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }


    public  boolean updateTemplate(NotificationTemplate template) {
        try{
            Connection con= Database.getConnection();
            Statement stmt = con.createStatement();
            tempTemplate = searchTemplates(template.id);
            if(tempTemplate != null)
            {

                query = "UPDATE templateTable SET content = '" + template.content + "'" +", subject = '" + template.subject + "'" + ",language = '" + template.language + "' WHERE tempID = '" + template.id + "'";
                stmt.executeUpdate(query);
                return true;
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    public NotificationTemplate getTemplate(int templateID) {
        tempTemplate = searchTemplates(templateID);
        return tempTemplate;
    }

    public NotificationTemplate searchTemplates(int templateID) {
        languageEnum obj = null;
        tempTemplate=new NotificationTemplate();
        try{

            Connection con= Database.getConnection();
            Statement stmt = con.createStatement();
            query = "SELECT * FROM templateTable where tempID = '" + templateID + "'";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next())
            {
                tempTemplate.id = Integer.parseInt(rs.getString("tempID"));
                tempTemplate.subject = rs.getString("subject");
                tempTemplate.content = rs.getString("content");

                if(rs.getString("language").equals("arabic"))
                    tempTemplate.language = obj.arabic;
                else
                    tempTemplate.language = obj.english;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return tempTemplate;
    }



}
