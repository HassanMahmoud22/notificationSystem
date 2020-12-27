package com.example.demo.infrastructure;

import com.example.demo.core.NotificationTemplate;

public interface TemplateDataAccessLayer {
    boolean addTemplate(NotificationTemplate var1);

    boolean deleteTemplate(int var1);

    boolean updateTemplate(NotificationTemplate var1);

    NotificationTemplate getTemplate(int var1);

    NotificationTemplate searchTemplates(int var1);
}
