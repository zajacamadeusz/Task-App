package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
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
public class TaskControllerTestSuite {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private DbService service;

    @Mock
    private TaskMapper taskMapper;

    @Test
    public void getTasksTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "test_title", "test_content"));
        taskList.add(new Task(2L, "test_title", "test_content"));
        taskList.add(new Task(3L, "test_title", "test_content"));

        when(taskController.getTasks()).thenReturn(taskMapper.mapToTaskDtoList(taskList));
        //When
        List<TaskDto> taskDtoList = taskController.getTasks();
        //Then
        assertEquals(3, taskDtoList.size());
    }

    @Test
    public void getTaskTest() {
        //Given
        Task task = new Task(1L, "test_title", "test_content");

        when(taskController.getTask()).thenReturn(taskMapper.mapToTaskDtoList(task));
        //When
        //Then
    }

    @Test
    public void deleteTaskTest() {
        //Given
        //When
        //Then
    }

    @Test
    public void updateTaskTest() {
        //Given
        //When
        //Then
    }

    @Test
    public void createTaskTest() {
        //Given
        //When
        //Then
    }

}
