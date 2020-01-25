package com.crud.tasks.trello.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloTestSuite {

    @Test
    public void testTrello() {
        //Given
        Trello trello = new Trello(1, 1);

        //When
        int board = trello.getBoard();
        int card = trello.getCard();

        //Then
        Assert.assertEquals(1, board);
        Assert.assertEquals(1, card);
    }
}
