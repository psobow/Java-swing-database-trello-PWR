package com.pwr.demo.client;

import com.pwr.demo.DemoApplication;
import com.pwr.demo.dto.TrelloBoardDto;
import com.pwr.demo.dto.TrelloCardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// Przed testami trzeba zakomentować anotacje @Component w klasie MainFrame

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TrelloClientTest {

    @Autowired
    TrelloClient trelloClient;

    @Test
    public void shouldPrintBoards(){
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsWithListsAndCards();

        trelloBoards.stream()
                .forEach(System.out::println);
    }

    @Test
    public void shouldPrintCards(){
        List<TrelloCardDto> trelloCards = trelloClient.getTrelloCardsInsideList("5bb868dc4706d96baf64be3b");
        trelloCards.stream()
                .forEach(System.out::println);
    }

    @Test
    public void shouldUpdateBoard(){
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsWithListsAndCards();

        trelloClient.putTrelloBoardName(trelloBoards.get(0),"NIE");

    }

    @Test
    public void shouldUpdateList(){
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsWithListsAndCards();

        trelloClient.putTrelloListName(trelloBoards.get(0).getLists().get(0), "Things to do");
    }

    @Test
    public void shouldUpdateCard(){
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsWithListsAndCards();
        TrelloCardDto cardDto = trelloBoards.get(0).getLists().get(0).getCards().get(0);

        trelloClient.putTrelloCardName(cardDto, "Create architecture for my app");
    }
}