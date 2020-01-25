package com.crud.tasks.trello.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void testTrelloApiEndpoint() {
        //When & Then
        Assert.assertEquals("https://api.trello.com/1", trelloConfig.getTrelloApiEndpoint());
    }

    @Test
    public void testTrelloAppKey() {
        //When & Then
        Assert.assertEquals("f80876bbec0bd233cf0b781644a24f8f", trelloConfig.getTrelloAppKey());
    }

    @Test
    public void testTrelloToken() {
        //When & Then
        Assert.assertEquals("ed17a53a3dc683a74336c12be3c77260c997d09f453532d58af77db226d67049", trelloConfig.getTrelloToken());
    }

    @Test
    public void testTrelloUsername() {
        //When & Then
        Assert.assertEquals("Nikoguj", trelloConfig.getTrelloUsername());
    }
}