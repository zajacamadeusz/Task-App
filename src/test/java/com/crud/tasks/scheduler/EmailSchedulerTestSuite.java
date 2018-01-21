package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTestSuite {

    @InjectMocks
    private EmailScheduler emailScheduler;

//    @Mock
//    private SimpleEmailService simpleEmailService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void shouldSendInformationEmail() {
        //Given
        when(taskRepository.count()).thenReturn(1L);
        when(adminConfig.getAdminMail()).thenReturn("zajacamadeusz7@gmail.com");
        Mail mail = new Mail("zajacamadeusz7@gmail.com", "Tasks: Once a day email",
                "Currently in database you got: " + 1L);
        //When
        emailScheduler.sendInformationEmail();
        //Then
        verify(emailScheduler, times(1)).sendInformationEmail();
    }
}
