package com.crud.tasks.trello.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BadgesTestSuite {

    @Test
    public void testBadges() {
        //Given
        Trello trello = new Trello(1, 1);
        AttachmentsByType attachmentsByType = new AttachmentsByType(trello);
        Badges badges = new Badges(3, attachmentsByType);

        //When
        AttachmentsByType attachmentsByType1 = badges.getAttachments();
        Trello trello1 = badges.getAttachments().getTrello();

        //Then
        Assert.assertNotNull(attachmentsByType1);
        Assert.assertEquals(3, badges.getVotes());
        Assert.assertNotNull(trello1);
        Assert.assertEquals(1, trello1.getBoard());
        Assert.assertEquals(1, trello1.getBoard());
    }
}
