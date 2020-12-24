
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class databaseDataAccessLayer  implements TemplateDataAccessLayer{
	Scanner stringInput = new Scanner(System.in);
	Scanner intInput = new Scanner(System.in);
	NotificationTemplate notification = new NotificationTemplate();
	
        public boolean addTemplate(NotificationTemplate template)
        {
        	try{  
        		Class.forName("com.mysql.jdbc.Driver");  
        		Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/notifications","root","hassan123");
        		Statement stmt = con.createStatement(); 
        		notification = searchTemplates(template.id);
        		if(notification == null)
        		{
        			String query = "INSERT INTO notificationTable(tempID, subject, content, language)" +
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
        		notification = searchTemplates(templateID);
                if(notification != null)
                {
                	String query = "DELETE FROM notificationTable WHERE tempID = '" + templateID + "'";
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
            	notification = searchTemplates(template.id);
        		if(notification != null)
        		{
        			String query = "UPDATE notificationTable SET content = '" + template.content + "'" +", subject = '" + template.subject + "'" + ",language = '" + template.language + "' WHERE id = '" + template.id + "'";
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
			LanguageEnum obj = null;
			notification = searchTemplates(templateID);
        	return notification;
        }

        public NotificationTemplate searchTemplates(int templateID) {
        	LanguageEnum obj = null;
        	try{  
        		Class.forName("com.mysql.jdbc.Driver");  
        		Connection con=DriverManager.getConnection(  
        		"jdbc:mysql://localhost:3306/notifications","root","hassan123");
        		Statement stmt = con.createStatement();  
        		String query = "SELECT * FROM notificationTable where tempID = '" + templateID + "'";
                ResultSet rs = stmt.executeQuery(query);       	
            	if(rs.next())
                {
            		notification.id = Integer.parseInt(rs.getString("tempID"));
            		notification.subject = rs.getString("subject");
            		notification.content = rs.getString("content");
        			
                	if(rs.getString("language").equals("arabic"))
                		notification.language = obj.arabic;
                	else
                		notification.language = obj.english;            	
                }
        	   }
        		catch(Exception e){
        		System.out.println(e);
        	}
        	return notification;
        }
    };
