import java.util.List;
import java.util.Scanner;

public class MemoryDataAccessLayer implements TemplateDataAccessLayer {
	List<NotificationTemplate> allTemplates;
	List<NotificationTemplate> allNotifications;
	NotificationTemplate tempTemplate = new NotificationTemplate();
	Scanner stringInput = new Scanner(System.in);
	Scanner intInput = new Scanner(System.in);
	databaseDataAccessLayer database = new databaseDataAccessLayer();
	
	public boolean addTemplate(NotificationTemplate template)
	{
		tempTemplate = database.searchTemplates(template.id);
		if(tempTemplate != null)
			return false;
		/*tempTemplate = searchTemplates(template.id);
		if(tempTemplate != null)
			return false;*/
		if(tempTemplate.content.contains("{x}"))
		{
			allTemplates.add(template);	
			database.addTemplate(template);
			return true;
		}
		return false;
	}
	
	public boolean deleteTemplate(int templateID)
	{
		tempTemplate = searchTemplates(templateID);
		boolean deleted = false;
		
		if(tempTemplate != null)
		{
			allTemplates.remove(tempTemplate);
			deleted = true;
		}
		if(database.deleteTemplate(templateID))
			deleted = true;
		return deleted;
	}
	
	public boolean updateTemplate(NotificationTemplate template)
	{
		tempTemplate = searchTemplates(template.id);
		boolean updated = false;
		if(tempTemplate != null)
		{
			tempTemplate.subject = template.subject;
			tempTemplate.content = template.content;
			tempTemplate.language = template.language;
			tempTemplate.sendType = template.sendType;
			deleteTemplate(tempTemplate.id);
			addTemplate(tempTemplate);
			updated = true;
		}
		if(database.updateTemplate(template))
			updated = true;
		return updated;
	}
	
	public NotificationTemplate getTemplate(int templateID)
	{
		tempTemplate = searchTemplates(templateID);
		if(tempTemplate != null)
			return tempTemplate;
		tempTemplate = database.searchTemplates(templateID);
		return tempTemplate;
	}
	
	public NotificationTemplate searchTemplates(int templateID)
	{
		NotificationTemplate template = null;
		int size = allTemplates.size();
		for(int i = 0; i < size; i++)
		{
			if(allTemplates.get(i).id == templateID)
				return allTemplates.get(i);
		}
		return template;
	}
	
	
}

