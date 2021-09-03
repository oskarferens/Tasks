package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(12L,"Title1", "Content1");

        //When
        Task result = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(12L, result.getId());
        assertEquals("Title1", result.getTitle());
        assertEquals("Content1", result.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(12L,"Title1", "Content1");

        //When
        TaskDto result = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(12L, result.getId());
        assertEquals("Title1", result.getTitle());
        assertEquals("Content1", result.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(12L,"Title1", "Content1"));

        //When
        List<TaskDto> result = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(12L, result.get(0).getId());
        assertEquals("Title1", result.get(0).getTitle());
        assertEquals("Content1", result.get(0).getContent());
    }
}
