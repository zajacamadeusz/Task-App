/*
package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllTasksTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "test_title", "test_content"));
        taskList.add(new Task(2L, "test_title", "test_content"));
        taskList.add(new Task(3L, "test_title", "test_content"));


        when(dbService.getAllTasks()).thenReturn(taskList);
        //When
        List<Task> taskDtoList = dbService.getAllTasks();
        //Then
        assertEquals(3, taskDtoList.size());
    }
    @Test
    public void getTask() {
        //Given
        Optional<Task> task = Optional.of(new Task(1L, "test_title", "test_content"));

        when(dbService.getTask(ArgumentMatchers.anyLong())).thenReturn(task);
        //When
        Optional<Task> tasks = dbService.getTask(1L);
        //Then
        assertEquals(tasks.get().getTitle(), task.get().getTitle());
    }

}


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
//
*/
