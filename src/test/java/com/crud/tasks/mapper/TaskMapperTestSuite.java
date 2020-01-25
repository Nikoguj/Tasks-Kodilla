package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapeer.TaskMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title1", "content1");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        Assert.assertEquals(new Long(1), task.getId());
        Assert.assertEquals("title1", task.getTitle());
        Assert.assertEquals("content1", task.getContent());
    }

    @Test
    public void testToTaskDto() {
        //Given
        Task task = new Task(1L, "title1", "content1");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        Assert.assertEquals(new Long(1), taskDto.getId());
        Assert.assertEquals("title1", taskDto.getTitle());
        Assert.assertEquals("content1", taskDto.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task(1L, "title1", "content1");
        Task task2 = new Task(2L, "title2", "content2");
        Task task3 = new Task(3L, "title3", "content3");
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertNotNull(taskDtoList);
        Assert.assertEquals(3, taskDtoList.size());
        Assert.assertEquals(new Long(1), taskDtoList.get(0).getId());
        Assert.assertEquals("title1", taskDtoList.get(0).getTitle());
        Assert.assertEquals("content1", taskDtoList.get(0).getContent());

    }
}
