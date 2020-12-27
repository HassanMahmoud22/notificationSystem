
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class databaseDataAccessLayer  implements TemplateDataAccessLayer{
	Scanner stringInput = new Scanner(System.in);
	Scanner intInput = new Scanner(System.in);
	NotificationTemplate tempTemplate = new NotificationTemplate();
	String query = "";
	
        public boolean addTemplate(NotificationTemplate template)
        {
        	try{  
        		Class.forName("com.mysql.jdbc.Driver");  
        		Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/notifications","root","hassan123");
        		Statement stmt = con.createStatement(); 
        		tempTemplate = searchTemplates(template.id);
        		if(tempTemplate == null)
        		{
        			query = "INSERT INTO templateTable(tempID, subject, content, language)" +
                            " values (" + template.id + ", '" + template.subject + "' ," + template.content + ", " + template.language + ");";
            		stmt.executeUpdate(query);
            		return true;
        		}
        	}
        	catch(Exception e){
        		System.out.println(e);
        	}  
        	return false;
        }
        
        public boolean deleteTemplate(int templateID) {
        	try{  
        		Class.forName("com.mysql.jdbc.Driver");  
        		Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/notifications","root","hassan123");
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
        		Class.forName("com.mysql.jdbc.Driver");  
        		Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/notifications","root","hassan123");
        		Statement stmt = con.createStatement();
        		tempTemplate = searchTemplates(template.id);
        		if(tempTemplate != null)
        		{
        			query = "UPDATE templateTable SET content = '" + template.content + "'" +", subject = '" + template.subject + "'" + ",language = '" + template.language + "' WHERE id = '" + template.id + "'";
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
        	LanguageEnum obj = null;
        	try{  
        		Class.forName("com.mysql.jdbc.Driver");  
        		Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/notifications","root","hassan123");
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
        
        public boolean addNotification(notification notify)
        {
        	boolean added = false;
        	try{  
        		Class.forName("com.mysql.jdbc.Driver");  
        		Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/notifications","root","hassan123");
        		Statement stmt = con.createStatement();
        		if(notify.sendType.equals("sms"))
        		{
        			query = "INSERT INTO smsNotification(tempID, subject, content, language, number, sendType)" +
                            " values (" + notify.id + ", '" + notify.subject + "' ," + notify.content + ", " + notify.language + "' ," + notify.number + ", " + notify.sendType + ");";
        			added = true;
        		}
        			
        		else if(notify.sendType.equals("mail"))
        		{
        			query = "INSERT INTO mailNotification(tempID, subject, content, language, email, sendType)" +
                            " values (" + notify.id + ", '" + notify.subject + "' ," + notify.content + ", " + notify.language + "' ," + notify.email + ", " + notify.sendType + ");";
        			added = true;
        		}
        			
        		stmt.executeUpdate(query);
        	}
        	catch(Exception e){
        		System.out.println(e);
        	}  
        	return added;
        }
    };
