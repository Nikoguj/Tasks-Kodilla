package com.crud.tasks.service;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.CreatedTrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.AdminConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Test
    public void testFetchTrelloBoards() {
        //Given
        List<TrelloListDto> trelloListDtoList1 = new ArrayList<>();
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "name2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "name3", false);
        TrelloListDto trelloListDto4 = new TrelloListDto("4", "name4", true);
        trelloListDtoList1.add(trelloListDto1);
        trelloListDtoList1.add(trelloListDto2);
        trelloListDtoList1.add(trelloListDto3);
        trelloListDtoList1.add(trelloListDto4);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "Board Name 1", trelloListDtoList1);

        List<TrelloListDto> trelloListDtoList2 = new ArrayList<>();
        TrelloListDto trelloListDto5 = new TrelloListDto("1", "name1", true);
        TrelloListDto trelloListDto6 = new TrelloListDto("2", "name2", false);
        TrelloListDto trelloListDto7 = new TrelloListDto("3", "name3", false);
        TrelloListDto trelloListDto8 = new TrelloListDto("4", "name4", true);
        trelloListDtoList2.add(trelloListDto5);
        trelloListDtoList2.add(trelloListDto6);
        trelloListDtoList2.add(trelloListDto7);
        trelloListDtoList2.add(trelloListDto8);

        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "Board Name 2", trelloListDtoList2);

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);

        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtoList);

        //When
        List<TrelloBoardDto> returnTrelloBoardDtoList1 = trelloService.fetchTrelloBoards();

        //Then
        Assert.assertNotNull(returnTrelloBoardDtoList1);
        Assert.assertEquals(2, returnTrelloBoardDtoList1.size());

        returnTrelloBoardDtoList1.forEach(trelloBoardDto -> {
            Assert.assertEquals(4, trelloBoardDto.getLists().size());

            for (int i = 0; i < trelloBoardDto.getLists().size(); i++) {
                Assert.assertEquals(String.valueOf(i + 1), trelloBoardDto.getLists().get(i).getId());
                Assert.assertEquals("name" + String.valueOf(i + 1), trelloBoardDto.getLists().get(i).getName());
            }
        });
    }

}