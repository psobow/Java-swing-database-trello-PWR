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

  public List<TrelloList> mapToDomain(final List<TrelloListDto> listDtoList){
    return listDtoList.stream()
                      .map(listDto -> new TrelloList(listDto.getTrelloId(),
                                                     listDto.getName(),
                                                     cardMapper.mapToDomain(listDto.getCards())))
                      .collect(Collectors.toList());
  }

  public List<TrelloListDto> mapToDto(final List<TrelloList> lists){
    return lists.stream()
                .map(list -> new TrelloListDto(list.getTrelloIdList(),
                                               list.getName(),
                                               cardMapper.mapToDto(list.getCards())))
                .collect(Collectors.toList());
  }
}
