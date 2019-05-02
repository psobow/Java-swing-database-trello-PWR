package com.pwr.demo.client;

import com.pwr.demo.config.TrelloConfig;
import com.pwr.demo.dto.TrelloBoardDto;
import com.pwr.demo.dto.TrelloCardDto;
import com.pwr.demo.dto.TrelloListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class TrelloClient {
  private final TrelloConfig trelloConfig;
  private final RestTemplate restTemplate;

  public void putTrelloBoardName(final TrelloBoardDto boardDto, final String newName){
    URI url = UriComponentsBuilder
        .fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/boards/" + boardDto.getId())
        .queryParam("key",     trelloConfig.getTrelloAppKey())//MainFrame.trelloKeyText.getText())
        .queryParam("token",   trelloConfig.getTrelloToken())//MainFrame.trelloTokenText.getText())
        .queryParam("name", newName)
        .build().encode().toUri();

    boardDto.setName(newName);

    try {
      restTemplate.put(url, boardDto);
    } catch (RestClientException e) {
      log.error(e.getMessage(), e);
    }
  }

  public void putTrelloListName(final TrelloListDto listDto, final String newName){
    URI url = UriComponentsBuilder
        .fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/lists/" + listDto.getId())
        .queryParam("key",     trelloConfig.getTrelloAppKey())//MainFrame.trelloKeyText.getText())
        .queryParam("token",   trelloConfig.getTrelloToken())//MainFrame.trelloTokenText.getText())
        .queryParam("name", newName)
        .build().encode().toUri();

    listDto.setName(newName);

    try {
      restTemplate.put(url, listDto);
    } catch (RestClientException e) {
      log.error(e.getMessage(), e);
    }
  }

  public void putTrelloCardName(final TrelloCardDto cardDto, final String newName){
    URI url = UriComponentsBuilder
        .fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/cards/" + cardDto.getId())
        .queryParam("key",     trelloConfig.getTrelloAppKey())//MainFrame.trelloKeyText.getText())
        .queryParam("token",   trelloConfig.getTrelloToken())//MainFrame.trelloTokenText.getText())
        .queryParam("name", newName)
        .build().encode().toUri();

    cardDto.setName(newName);

    try {
      restTemplate.put(url, cardDto);
    } catch (RestClientException e) {
      log.error(e.getMessage(), e);
    }

  }

  public List<TrelloBoardDto> getTrelloBoardsWithListsAndCards() {
    URI url = UriComponentsBuilder
        .fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/members/" + trelloConfig.getTrelloLogin() + "/boards")
        .queryParam("key",     trelloConfig.getTrelloAppKey())//MainFrame.trelloKeyText.getText())
        .queryParam("token",   trelloConfig.getTrelloToken())//MainFrame.trelloTokenText.getText())
        .queryParam("fields", "name,id")
        .queryParam("lists",  "all")
        .build().encode().toUri();

    try {
      TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);

      Arrays.asList(Optional.ofNullable(boardsResponse)
                            .orElse(new TrelloBoardDto[0]))
            .forEach(board -> Optional.ofNullable(board.getLists())
                                      .orElse(new ArrayList<>())
                                      .forEach(list -> list.setCards(getTrelloCardsInsideList(list.getId())))
            );


      return Arrays.asList(Optional.ofNullable(boardsResponse).orElse(new TrelloBoardDto[0]));

    } catch (RestClientException e) {
      log.error(e.getMessage(), e);
      return new ArrayList<>();
    }
  }

  List<TrelloCardDto> getTrelloCardsInsideList(final String listId){
    URI url = UriComponentsBuilder
        .fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/lists/" + listId + "/cards")
        .queryParam("key", trelloConfig.getTrelloAppKey())//MainFrame.trelloKeyText.getText())
        .queryParam("token", trelloConfig.getTrelloToken())//MainFrame.trelloTokenText.getText())
        .queryParam("fields", "name,id,idList")
        .build().encode().toUri();

    try {
      TrelloCardDto[] cardsResponse = restTemplate.getForObject(url, TrelloCardDto[].class);
      return Arrays.asList(Optional.ofNullable(cardsResponse).orElse(new TrelloCardDto[0]));

    } catch (RestClientException e) {
      log.error(e.getMessage(), e);
       return new ArrayList<>();
    }

  }
}
