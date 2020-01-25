package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapeer.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MapperTestSuite {

    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "name2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "name3", false);

        trelloListDto.add(trelloListDto1);
        trelloListDto.add(trelloListDto2);
        trelloListDto.add(trelloListDto3);

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);

        //Then
        Assert.assertEquals(3, trelloList.size());
        Assert.assertEquals("1", trelloList.get(0).getId());
        Assert.assertEquals("name2", trelloList.get(1).getName());
        Assert.assertFalse(trelloList.get(2).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("1", "name1", true);
        TrelloList trelloList2 = new TrelloList("2", "name2", true);
        TrelloList trelloList3 = new TrelloList("3", "name3", false);

        trelloList.add(trelloList1);
        trelloList.add(trelloList2);
        trelloList.add(trelloList3);

        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);

        //Then
        Assert.assertEquals(3, trelloListDto.size());
        Assert.assertEquals("1", trelloListDto.get(0).getId());
        Assert.assertEquals("name2", trelloListDto.get(1).getName());
        Assert.assertFalse(trelloListDto.get(2).isClosed());
    }

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloListDtoList1 = new ArrayList<>();
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "name2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "name3", false);
        trelloListDtoList1.add(trelloListDto1);
        trelloListDtoList1.add(trelloListDto2);
        trelloListDtoList1.add(trelloListDto3);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "trelloBoardName1", trelloListDtoList1);

        List<TrelloListDto> trelloListDtoList2 = new ArrayList<>();
        TrelloListDto trelloListDto4 = new TrelloListDto("1", "name1", true);
        TrelloListDto trelloListDto5 = new TrelloListDto("2", "name2", true);
        TrelloListDto trelloListDto6 = new TrelloListDto("3", "name3", false);
        trelloListDtoList2.add(trelloListDto4);
        trelloListDtoList2.add(trelloListDto5);
        trelloListDtoList2.add(trelloListDto6);

        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "trelloBoardName2", trelloListDtoList2);

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        Assert.assertEquals(2, trelloBoardList.size());

        Assert.assertEquals("1", trelloBoardList.get(0).getId());
        Assert.assertEquals("trelloBoardName1", trelloBoardList.get(0).getName());

        Assert.assertEquals("2", trelloBoardList.get(1).getId());
        Assert.assertEquals("trelloBoardName2", trelloBoardList.get(1).getName());

        Assert.assertEquals("1", trelloBoardList.get(0).getLists().get(0).getId());
        Assert.assertEquals("name2", trelloBoardList.get(0).getLists().get(1).getName());
        Assert.assertFalse(trelloBoardList.get(0).getLists().get(2).isClosed());

        Assert.assertEquals("1", trelloBoardList.get(1).getLists().get(0).getId());
        Assert.assertEquals("name2", trelloBoardList.get(1).getLists().get(1).getName());
        Assert.assertFalse(trelloBoardList.get(1).getLists().get(2).isClosed());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloList> trelloListList1 = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("1", "name1", true);
        TrelloList trelloList2 = new TrelloList("2", "name2", true);
        TrelloList trelloList3 = new TrelloList("3", "name3", false);
        trelloListList1.add(trelloList1);
        trelloListList1.add(trelloList2);
        trelloListList1.add(trelloList3);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "trelloBoardName1", trelloListList1);

        List<TrelloList> trelloListList2 = new ArrayList<>();
        TrelloList trelloList4 = new TrelloList("1", "name1", true);
        TrelloList trelloList5 = new TrelloList("2", "name2", true);
        TrelloList trelloList6 = new TrelloList("3", "name3", false);
        trelloListList2.add(trelloList4);
        trelloListList2.add(trelloList5);
        trelloListList2.add(trelloList6);

        TrelloBoard trelloBoard2 = new TrelloBoard("2", "trelloBoardName2", trelloListList2);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        Assert.assertEquals(2, trelloBoardDtoList.size());

        Assert.assertEquals("1", trelloBoardDtoList.get(0).getId());
        Assert.assertEquals("trelloBoardName1", trelloBoardDtoList.get(0).getName());

        Assert.assertEquals("2", trelloBoardDtoList.get(1).getId());
        Assert.assertEquals("trelloBoardName2", trelloBoardDtoList.get(1).getName());

        Assert.assertEquals("1", trelloBoardDtoList.get(0).getLists().get(0).getId());
        Assert.assertEquals("name2", trelloBoardDtoList.get(0).getLists().get(1).getName());
        Assert.assertFalse(trelloBoardDtoList.get(0).getLists().get(2).isClosed());

        Assert.assertEquals("1", trelloBoardDtoList.get(1).getLists().get(0).getId());
        Assert.assertEquals("name2", trelloBoardDtoList.get(1).getLists().get(1).getName());
        Assert.assertFalse(trelloBoardDtoList.get(1).getLists().get(2).isClosed());
    }

    @Test
    public void testMapToCartDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name1", "description1", "pos1", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCartDto(trelloCard);

        //Then
        Assert.assertEquals("name1", trelloCardDto.getName());
        Assert.assertEquals("description1", trelloCardDto.getDescription());
        Assert.assertEquals("pos1", trelloCardDto.getPos());
        Assert.assertEquals("1", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCart() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name1", "description1", "pos1", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCart(trelloCardDto);

        //Then
        Assert.assertEquals("name1", trelloCard.getName());
        Assert.assertEquals("description1", trelloCard.getDescription());
        Assert.assertEquals("pos1", trelloCard.getPos());
        Assert.assertEquals("1", trelloCard.getListId());
    }
}