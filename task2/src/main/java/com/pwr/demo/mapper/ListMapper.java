package com.pwr.demo.mapper;

import com.pwr.demo.domain.TrelloList;
import com.pwr.demo.dto.TrelloListDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListMapper {
  @Autowired
  CardMapper cardMapper;

  public TrelloList mapToTrelloList(final TrelloListDto listDto){
    return new TrelloList(listDto.getId(),
                          listDto.getName(),
                          cardMapper.mapToListTrelloCard(listDto.getCards()));
  }

  public List<TrelloList> mapToListTrelloList(final List<TrelloListDto> listDtoList){
    return listDtoList.stream()
                      .map(listDto -> new TrelloList(listDto.getId(),
                                                     listDto.getName(),
                                                     cardMapper.mapToListTrelloCard(listDto.getCards())))
                      .collect(Collectors.toList());
  }
}
