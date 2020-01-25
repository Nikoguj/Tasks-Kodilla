package com.crud.tasks.trello.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatedTrelloCardDtoTestSuite {

    @Test
    public void testCreatedTrelloCardDto() {
        //Given
        Trello trello = new Trello(1, 1);
        AttachmentsByType attachmentsByType = new AttachmentsByType(trello);
        Badges badges = new Badges(3, attachmentsByType);

        //When
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "name1", "shortUrl1", badges);

        //Then
        Assert.assertNotNull(createdTrelloCardDto);
        Assert.assertEquals("1", createdTrelloCardDto.getId());
        Assert.assertEquals("name1", createdTrelloCardDto.getName());
        Assert.assertEquals("shortUrl1", createdTrelloCardDto.getShortUrl());
        Assert.assertEquals(badges, createdTrelloCardDto.getBadges());
    }
}
