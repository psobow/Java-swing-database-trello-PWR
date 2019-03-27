package com.pwr.demo.client;

import com.pwr.demo.dto.TrelloBoardDto;
import com.pwr.demo.dto.TrelloCardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloClientTest {
    @Autowired
    TrelloClient trelloClient;

    @Test
    public void shouldPrintBoards(){
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsWithLists();

        trelloBoards.stream()
                .forEach(System.out::println);
    }

    @Test
    public void fetchTrelloCardsInsideListTest(){
        List<TrelloCardDto> trelloCards = trelloClient.fetchTrelloCardsInsideList("5bb868dc4706d96baf64be3b");

        trelloCards.stream()
                .forEach(System.out::println);
    }
}