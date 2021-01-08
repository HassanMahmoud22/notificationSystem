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
        tempTemplate = database.searchTemplates(template.context);
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

    public boolean deleteTemplate(String tempContext)
    {
        tempTemplate = searchTemplates(tempContext);
        boolean deleted = false;

        if(tempTemplate != null)
        {
            allTemplates.remove(tempTemplate);
            deleted = true;
        }
        if(database.deleteTemplate(tempContext))
            deleted = true;
        return deleted;
    }

    public boolean updateTemplate(NotificationTemplate template)
    {
        tempTemplate = searchTemplates(template.context);
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

    public NotificationTemplate getTemplate(String tempContext)
    {
        /*
        tempTemplate = searchTemplates(templateID);
        if(tempTemplate != null)
            return tempTemplate;*/
        tempTemplate = database.searchTemplates(tempContext);
        return tempTemplate;
    }

    public NotificationTemplate searchTemplates(String tempContext)
    {

        return   database.searchTemplates(tempContext);
    }


}