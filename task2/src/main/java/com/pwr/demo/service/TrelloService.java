package com.pwr.demo.service;

import com.pwr.demo.client.TrelloClient;
import com.pwr.demo.domain.TrelloCard;
import com.pwr.demo.dto.TrelloBoardDto;
import com.pwr.demo.dto.TrelloCardDto;
import com.pwr.demo.dto.TrelloListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrelloService {
  private final TrelloClient TRELLO_CLIENT;


  public List<TrelloBoardDto> getTrelloBoardsWithListsAndCards(){
    return TRELLO_CLIENT.getTrelloBoardsWithListsAndCards();
  }

  public void putTrelloCardName(final TrelloCardDto cardDto, final String newName){
    TRELLO_CLIENT.putTrelloCardName(cardDto,newName);
  }

  public void putTrelloListName(final TrelloListDto listDto, final String newName){
    TRELLO_CLIENT.putTrelloListName(listDto,newName);
  }

  public void putTrelloBoardName(final TrelloBoardDto boardDto, final String newName){
    TRELLO_CLIENT.putTrelloBoardName(boardDto,newName);
  }
}
