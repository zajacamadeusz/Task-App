/*
package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

//    @Test
//    public void getAllTasksTest() {
//        //Given
//        List<Task> taskList = new ArrayList<>();
//        taskList.add(new Task(1L, "test_title", "test_content"));
//        taskList.add(new Task(2L, "test_title", "test_content"));
//        taskList.add(new Task(3L, "test_title", "test_content"));
//
//
////        when(dbService.getAllTasks()).thenReturn(taskRepository.findAll());
//        //When
//        List<Task> taskDtoList = dbService.getAllTasks();
//        //Then
//        assertEquals(3, taskDtoList.size());
//    }
//
//}



//    private TaskRepository repository;
//
//    public List<Task> getAllTasks() {
//        return repository.findAll();
//    }
//
//    public Optional<Task> getTask(final Long id) {
//        return repository.findById(id);
//    }
//
//    public Task saveTask(final Task task) {
//        return repository.save(task);
//    }
//
//    public void deleteTask(final Long id) {
//        repository.deleteById(id);
//    }
//`*/
