package com.pwr.demo.mapper;

import com.pwr.demo.domain.TrelloBoard;
import com.pwr.demo.dto.TrelloBoardDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {
  @Autowired
  ListMapper listMapper;

  public TrelloBoard mapToTrelloBoard(final TrelloBoardDto boardDto){
    return new TrelloBoard(boardDto.getId(),
                           boardDto.getName(),
                           listMapper.mapToListTrelloList(boardDto.getLists()));
  }

  public List<TrelloBoard> mapToListTrelloBoard(final List<TrelloBoardDto> boardDtos){
    return boardDtos.stream()
                    .map(boardDto -> mapToTrelloBoard(boardDto))
                    .collect(Collectors.toList());
  }
}
