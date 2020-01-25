package com.crud.tasks.scheduler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSchedulerTestSuite {

    @Test
    public void testTskOrTasks1() {
        //Given
        EmailScheduler emailScheduler = new EmailScheduler();
        //When
        String returnString = emailScheduler.taskOrTasks(1);
        //Then
        Assert.assertEquals("task", returnString);
    }

    @Test
    public void testTskOrTasks2() {
        //Given
        EmailScheduler emailScheduler = new EmailScheduler();
        //When
        String returnString = emailScheduler.taskOrTasks(20);
        //Then
        Assert.assertEquals("tasks", returnString);
    }
}
