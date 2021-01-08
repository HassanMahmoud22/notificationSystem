package com.example.demo.infrastructure;

import com.example.demo.core.NotificationTemplate;

public interface TemplateDataAccessLayer {
    boolean addTemplate(NotificationTemplate temp);

    boolean deleteTemplate(String tempContext);

    boolean updateTemplate(NotificationTemplate temp);

    NotificationTemplate getTemplate(String tempContext);

    NotificationTemplate searchTemplates(String tempContext);
}