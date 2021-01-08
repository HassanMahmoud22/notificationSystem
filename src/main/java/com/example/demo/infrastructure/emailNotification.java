package com.example.demo.infrastructure;

import com.example.demo.connection.Database;
import com.example.demo.core.notification;

import java.sql.Connection;
import java.sql.Statement;;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class emailNotification extends notificationLayer {
	
    String query = "";
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public emailNotification(){};


    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
	 public boolean addNotification(notification notify)
	    {
	        boolean added = false;
	        try{
	            Connection con= Database.getConnection();
	            Statement stmt = con.createStatement();
	            
	            	if(validate(notify.email))
	                {

	                    query = "INSERT INTO emailNotification(context,subject,content,status,email) VALUES("
	                    + "'" + notify.context + "',"
	                    + "'" + notify.subject + "',"
	                    + "'" + notify.content+ "',"
	                    + "'" + "success"+ "',"
	                    + "'" + notify.email  + "')";

	                 added = true;
	                  stmt.executeUpdate(query);
	              }
	              else
	              {
	                query = "INSERT INTO emailNotification(context,subject,content,status,email) VALUES("
	                        + "'" + notify.context + "',"
	                        + "'" + notify.subject + "',"
	                        + "'" + notify.content+ "',"
	                        + "'" + "failed"+ "',"
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
}
