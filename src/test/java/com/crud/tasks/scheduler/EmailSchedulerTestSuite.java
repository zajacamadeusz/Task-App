package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTestSuite {

    @InjectMocks
    private EmailScheduler emailScheduler;

    @MockBean
    private SimpleEmailService simpleEmailService;

    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private AdminConfig adminConfig;

    @Test
    public void shouldSendInformationEmail() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "Test Title", "Test Content"));
        tasks.add(new Task(2L, "Test Title", "Test Content"));
        tasks.add(new Task(3L, "Test Title", "Test Content"));
        Mail mail = new Mail("zajacamadeusz7@gmail.com", "Tasks: Once a day email",
                "Currently in database you got: " + tasks.size());
        String adminMail = "zajacamadeusz7@gmail.com";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
//
//        when(adminConfig.getAdminMail()).thenReturn(adminMail);
        when(taskRepository.count()).thenReturn(Long.valueOf(tasks.size()));
        //When
        emailScheduler.sendInformationEmail();
        //Then

    }
}
