package com.pwr.demo.mapper;

import com.pwr.demo.domain.TrelloCard;
import com.pwr.demo.dto.TrelloCardDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
  public List<TrelloCard> mapToDomain(final List<TrelloCardDto> cardDtoList){
    return cardDtoList.stream()
                      .map(card -> new TrelloCard(card.getTrelloId(),
                                                  card.getTrelloListId(),
                                                  card.getName()))
                      .collect(Collectors.toList());
  }

  public List<TrelloCardDto> mapToDto(final List<TrelloCard> cardList){
    return cardList.stream()
                   .map(card -> new TrelloCardDto(card.getTrelloIdCard(),
                                                  card.getTrelloIdList(),
                                                  card.getName()))
                   .collect(Collectors.toList());
  }
}
