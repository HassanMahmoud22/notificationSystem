import java.util.List;

public interface TemplateDataAccessLayer {
	public boolean addTemplate(NotificationTemplate template);
	public boolean deleteTemplate(int templateID);
	public boolean updateTemplate(NotificationTemplate template);
	public NotificationTemplate getTemplate(int templateID);
	public NotificationTemplate searchTemplates(int templateID);
	
}
