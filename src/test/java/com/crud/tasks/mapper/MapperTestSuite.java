package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class MapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;
    @InjectMocks
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

    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(new TrelloListDto("firstId", "firstElement", true));
        trelloListDtoList.add(new TrelloListDto("secondId", "secondElement", true));
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("firstID", "firstName", trelloListDtoList));
        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals(trelloBoardDtoList.get(0).getId(), trelloBoardList.get(0).getId());
        assertEquals(trelloBoardDtoList.get(0).getName(), trelloBoardList.get(0).getName());
        assertEquals(trelloBoardDtoList.get(0).getLists().size(), trelloBoardList.get(0).getLists().size());
        assertEquals(trelloBoardDtoList.size(), trelloBoardList.size());
    }

    @Test
    public void mapToBoardsDtoTest() {
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(new TrelloList("firstId", "firstElement", true));
        trelloListList.add(new TrelloList("secondId", "secondElement", true));
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(new TrelloBoard("firstID", "firstName", trelloListList));
        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        assertEquals(trelloBoardList.get(0).getId(), trelloBoardDtoList.get(0).getId());
        assertEquals(trelloBoardList.get(0).getName(), trelloBoardDtoList.get(0).getName());
        assertEquals(trelloBoardList.get(0).getLists().size(), trelloBoardDtoList.get(0).getLists().size());
        assertEquals(trelloBoardList.size(), trelloBoardDtoList.size());
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(new TrelloListDto("firstId", "firstName", true));
        trelloListDtoList.add(new TrelloListDto("secondId", "secondName", true));
        trelloListDtoList.add(new TrelloListDto("thirdId", "thirdName", true));
        //When
        List<TrelloList> trelloListList = trelloMapper.maptoList(trelloListDtoList);
        //Then
        assertEquals(trelloListDtoList.get(0).getId(), trelloListList.get(0).getId());
        assertEquals(trelloListDtoList.get(0).getName(), trelloListList.get(0).getName());
        assertEquals(trelloListDtoList.get(0).isClosed(), trelloListList.get(0).isClosed());
        assertEquals(trelloListDtoList.size(), trelloListList.size());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(new TrelloList("firstId", "firstName", true));
        trelloListList.add(new TrelloList("secondId", "secondName", true));
        trelloListList.add(new TrelloList("thirdId", "thirdName", true));
        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.maptoListDto(trelloListList);
        //Then
        assertEquals(trelloListList.get(0).getId(), trelloListDtoList.get(0).getId());
        assertEquals(trelloListList.get(0).getName(), trelloListDtoList.get(0).getName());
        assertEquals(trelloListList.get(0).isClosed(), trelloListDtoList.get(0).isClosed());
        assertEquals(trelloListList.size(), trelloListDtoList.size());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("firstName", "firstDescription",
                "firstPos", "firstListid");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("firstName", "firstDescription",
                "firstPos", "firstListid");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }
}
