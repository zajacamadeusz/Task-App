package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private CompanyConfig companyConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionalisty = new ArrayList<> ();
        functionalisty.add ("You can manage your tasks");
        functionalisty.add ("Provides connection with Trello Acount");
        functionalisty.add ("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable ("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable ("button", "Visit website");
        context.setVariable ("admin_name", adminConfig.getAdminMail ());
        context.setVariable ("company_name", companyConfig.getCompanyName ());
        context.setVariable ("company_goal", companyConfig.getCompanyGoal ());
        context.setVariable ("company_mail", companyConfig.getCompanyMail ());
        context.setVariable ("show_button", false);
        context.setVariable ("is_friend", true);
        context.setVariable ("admin_config", adminConfig);
        context.setVariable ("application_functionality", functionalisty);
        return templateEngine.process ("mail/created-trello-card-mail", context);
    }
}
