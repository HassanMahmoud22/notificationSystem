import java.util.List;
import java.util.Scanner;

public class MemoryDataAccessLayer implements TemplateDataAccessLayer {
	List<NotificationTemplate> allNotifications;
	NotificationTemplate notification = new NotificationTemplate();
	Scanner stringInput = new Scanner(System.in);
	Scanner intInput = new Scanner(System.in);
	
	public boolean addTemplate(NotificationTemplate template)
	{
		notification = searchTemplates(template.id);
		if(notification == null)
		{
			allNotifications.add(notification);
			return true;
		}
		return false;
	}
	
	public boolean deleteTemplate(int templateID)
	{
		notification = searchTemplates(templateID);
		if(notification != null)
		{
			allNotifications.remove(notification);
			return true;
		}
		return false;
	}
	
	public boolean updateTemplate(NotificationTemplate template)
	{
		notification = searchTemplates(template.id);
		if(notification != null)
		{
			LanguageEnum obj = null;
			System.out.println("Enter new Subject");
			String subject = stringInput.nextLine();
			System.out.println("Enter new content");
			String content = stringInput.nextLine();
			System.out.println("choose Language \n 1- arabic 2- english");
			int choice = intInput.nextInt();
			while(choice != 1 || choice != 2)
			{
				System.out.println("Enter 1 or 2");
				choice = intInput.nextInt();
			}
			if(choice == 1)
				template.language = obj.arabic;
			else
				template.language = obj.english;
			template.content = content;
			template.subject = subject;
			return true;
		}		
		return false;
	}
	
	public NotificationTemplate getTemplate(int templateID)
	{
		notification = searchTemplates(templateID);
		return notification;
	}
	
	public NotificationTemplate searchTemplates(int templateID)
	{
		NotificationTemplate template = null;
		int size = allNotifications.size();
		for(int i = 0; i < size; i++)
		{
			if(allNotifications.get(i).id == templateID)
				return allNotifications.get(i);
		}
		return template;
	}

}

