package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void shouldFetchTasks() throws Exception {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "test_title", "test_content"));
        tasks.add(new Task(2L, "test_title", "test_content"));

        when(dbService.getAllTasks()).thenReturn(tasks);
        //When & Then
        mockMvc.perform(get("v1/tasks/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1L)))
                .andExpect(jsonPath("$[0].title", is("test_title")))
                .andExpect(jsonPath("$[0].content", is("test_content")))
                .andExpect(jsonPath("$[1].id", is(2L)))
                .andExpect(jsonPath("$[1].title", is("test_title")))
                .andExpect(jsonPath("$[1].content", is("test_content")));
    }

    @Test
    public void getTaskTest() throws Exception {
        //Given
        Optional<TaskDto> task  = Optional.of(new TaskDto(1L, "test_title", "test_content"));

        when(dbService.getTask(ArgumentMatchers.anyLong())).thenReturn(taskMapper.mapToTask(task));
        //When & Then
        mockMvc.perform(get("v1/tasks/getTask").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1L)))
                .andExpect(jsonPath("$.title", is("test_title")))
                .andExpect(jsonPath("$.content", is("test_content")));
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given
        Task task = new Task(1L, "test_title", "test_content");

        when(dbService.deleteTask(ArgumentMatchers.anyLong())).thenReturn(task);
        //When & Then
        mockMvc.perform(delete("v1/tasks/deleteTask").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1L)))
                .andExpect(jsonPath("$.title", is("test_title")))
                .andExpect(jsonPath("$.content", is("test_content")));
    }

    @Test
    public void shouldSaveTask() throws Exception {
        //Given
        Task task = new Task(1L, "test_title", "test_content");

        when(dbService.saveTask(ArgumentMatchers.any(Task.class))).thenReturn(task);
        //When & Then
        mockMvc.perform(post("v1/tasks/createTask").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1L)))
                .andExpect(jsonPath("$.title", is("test_title")))
                .andExpect(jsonPath("$.content", is("test_content")));
    }
}
