package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTestSuite {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        List<TrelloList> trelloLists1 = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("1", "name1", false);
        TrelloList trelloList2 = new TrelloList("2", "name2", false);
        TrelloList trelloList3 = new TrelloList("3", "name3", true);
        trelloLists1.add(trelloList1);
        trelloLists1.add(trelloList2);
        trelloLists1.add(trelloList3);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "Trello Board 1", trelloLists1);

        List<TrelloList> trelloLists2 = new ArrayList<>();
        TrelloList trelloList4 = new TrelloList("1", "name1", false);
        TrelloList trelloList5 = new TrelloList("2", "name2", false);
        TrelloList trelloList6 = new TrelloList("3", "name3", false);
        trelloLists2.add(trelloList4);
        trelloLists2.add(trelloList5);
        trelloLists2.add(trelloList6);

        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Test", trelloLists2);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);

        //When
        List<TrelloBoard> filterTrelloBoard = trelloValidator.validateTrelloBoards(trelloBoardList);

        //Then
        Assert.assertNotNull(filterTrelloBoard);
        Assert.assertEquals(1, filterTrelloBoard.size());
        Assert.assertEquals(3, filterTrelloBoard.get(0).getLists().size());
    }
}
