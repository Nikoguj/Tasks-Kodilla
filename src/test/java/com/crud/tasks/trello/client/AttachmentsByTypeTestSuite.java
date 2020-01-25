package com.crud.tasks.trello.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttachmentsByTypeTestSuite {
    @Test
    public void testAttachmentsByType() {
        //Given
        Trello trello = new Trello(1, 1);
        AttachmentsByType attachmentsByType = new AttachmentsByType(trello);

        //When
        Trello trello1 = attachmentsByType.getTrello();

        //Then
        Assert.assertNotNull(trello1);
        Assert.assertEquals(1, trello1.getBoard());
        Assert.assertEquals(1, trello1.getBoard());
    }
}
