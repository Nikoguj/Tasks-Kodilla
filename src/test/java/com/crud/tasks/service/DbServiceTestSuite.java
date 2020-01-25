package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task(1L, "title1", "content1");
        Task task2 = new Task(2L, "title2", "content2");
        Task task3 = new Task(3L, "title3", "content3");
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> returnTaskList = dbService.getAllTasks();

        //Then
        Assert.assertNotNull(returnTaskList);
        Assert.assertEquals(3, returnTaskList.size());

        Assert.assertEquals(new Long(1), returnTaskList.get(0).getId());
        Assert.assertEquals("title2", returnTaskList.get(1).getTitle());
        Assert.assertEquals("content3", returnTaskList.get(2).getContent());
    }

    @Test
    public void testSaveTask() {
        //Given
        Task myTask = new Task(4L, "title4", "content4");

        when(taskRepository.save(myTask)).thenReturn(myTask);

        //When
        Task returnTask = dbService.saveTask(myTask);

        //Then
        Assert.assertNotNull(returnTask);
        Assert.assertEquals(new Long(4L), returnTask.getId());
        Assert.assertEquals("title4", returnTask.getTitle());
        Assert.assertEquals("content4", returnTask.getContent());
    }

    @Test
    public void testGetTask() {
        //Given
        Optional<Task> myTask = Optional.of(new Task(4L, "title4", "content4"));

        when(taskRepository.findById(4L)).thenReturn(myTask);

        //When
        Optional<Task> returnTask = dbService.getTask(4L);

        //Then
        Assert.assertNotNull(returnTask);
        Assert.assertEquals(new Long(4L), returnTask.get().getId());
        Assert.assertEquals("title4", returnTask.get().getTitle());
        Assert.assertEquals("content4", returnTask.get().getContent());
    }
}
