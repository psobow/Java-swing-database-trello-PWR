package com.pwr.demo.mapper;

import com.pwr.demo.domain.TrelloCard;
import com.pwr.demo.domain.TrelloList;
import com.pwr.demo.dto.TrelloCardDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {
  public List<TrelloCard> mapToListTrelloCard(final List<TrelloCardDto> cardDtoList){
    return cardDtoList.stream()

                      .map(card -> new TrelloCard(card.getId(),
                                                  card.getIdList(),
                                                  card.getName()))
                      .collect(Collectors.toList());
  }
}
