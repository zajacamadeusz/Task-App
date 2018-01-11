package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "firstTitle", "firstContent");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(taskDto.getContent(), task.getContent());
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "firstTitle", "firstContent");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(task.getContent(), taskDto.getContent());
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "firstTitle", "firstContent"));
        //When
        List<TaskDto> tasksDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(taskList.get(0).getContent(), tasksDtoList.get(0).getContent());
        assertEquals(taskList.get(0).getId(), tasksDtoList.get(0).getId());
        assertEquals(taskList.get(0).getTitle(), tasksDtoList.get(0).getTitle());
        assertEquals(taskList.size(), tasksDtoList.size());
    }
}
