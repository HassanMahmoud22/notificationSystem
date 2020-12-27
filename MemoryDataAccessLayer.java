package com.example.demo.infrastructure;

import com.example.demo.core.NotificationTemplate;

import java.util.ArrayList;
import java.util.List;
public class MemoryDataAccessLayer implements TemplateDataAccessLayer{
    List<NotificationTemplate> allTemplates= new ArrayList<>();
    NotificationTemplate tempTemplate = new NotificationTemplate();
    databaseDataAccessLayer database = new databaseDataAccessLayer();

   public MemoryDataAccessLayer(){

    }
    public boolean addTemplate(NotificationTemplate template)
    {
        tempTemplate = database.searchTemplates(template.id);
        if(tempTemplate.content != null)
            return false;
        else if(template.content.contains("{x}"))
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
            database.updateTemplate(template);
            updated = true;

        }

        return updated;
    }

    public NotificationTemplate getTemplate(int templateID)
    {
        /*
        tempTemplate = searchTemplates(templateID);
        if(tempTemplate != null)
            return tempTemplate;*/
        tempTemplate = database.searchTemplates(templateID);
        return tempTemplate;
    }

    public NotificationTemplate searchTemplates(int templateID)
    {

        return   database.searchTemplates(templateID);
    }


}
