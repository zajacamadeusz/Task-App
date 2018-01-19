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
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        List<TaskDto> tasksDto = new ArrayList<>();
        tasksDto.add(new TaskDto(1L, "test_title", "test_content"));
        tasksDto.add(new TaskDto(2L, "test_title", "test_content"));

        when(dbService.getAllTasks()).thenReturn(tasks);
        when(taskMapper.mapToTaskDtoList(any())).thenReturn(tasksDto);
        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("test_title")))
                .andExpect(jsonPath("$[0].content", is("test_content")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("test_title")))
                .andExpect(jsonPath("$[1].content", is("test_content")));
    }
    // przy gecie moge stestowac 2 sciezki -> podaje id tego zmapowanego czy zwrocony zostal oczekiwany ten jeden task a
    //drugi ten to zrobimy druga czesc ze serwis dbservice nei zwroic zadnego taska czyli zrobimy rzucenie wyjatku
    // zeby zadziallalo nad wyjatkiem adnotacka


    //wtedy status().isNotFound()
    //parametr dodac tez przy gettask bo wywolujemy z parametrem

/*
    @Test
    public void getTaskTest() throws Exception {
        //Given
        Optional<TaskDto> task  = Optional.of(new TaskDto(1L, "test_title", "test_content"));

        when(dbService.getTask(ArgumentMatchers.anyLong())).thenReturn(taskMapper.mapToTask(task));
        //When & Then
        mockMvc.perform(get("/v1/task/getTask").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1L)))
                .andExpect(jsonPath("$.title", is("test_title")))
                .andExpect(jsonPath("$.content", is("test_content")));
    }
*/

    @Test
    public void shouldDeleteTask() throws Exception {
        //Given

        //When & Then
        mockMvc.perform(delete("/v1/task//deleteTask")
                .param("id", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(dbService, times(1)).deleteTask(1L);
    }

    @Test
    public void shouldCreateTask() throws Exception {
        //Given
        Task task = new Task(1L, "test_title", "test_content");

        when(dbService.saveTask(any(Task.class))).thenReturn(task);
        //When & Then
        mockMvc.perform(post("/v1/task//createTask").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //dorzucic contenta to co chcemy wyslac zmapowac do jsona i jako content wrzucic do content()
        //zalezyc zy mockuje mappera czy nie
        // wteyd muzse sprawdzic czys ie zmapowala
        //
        verify(dbService, times(1)).deleteTask(task.getId());
    }

    @Test
    public void shouldUpdateTask() throws Exception {
        //Given
        //When & Then
    }
}
