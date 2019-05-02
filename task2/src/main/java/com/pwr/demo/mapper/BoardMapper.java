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

  public List<TrelloBoard> mapToDomain(final List<TrelloBoardDto> boardDtos){
    return boardDtos.stream()
                    .map(boardDto -> new TrelloBoard(boardDto.getTrelloId(),
                                                     boardDto.getName(),
                                                     listMapper.mapToDomain(boardDto.getLists())))
                    .collect(Collectors.toList());
  }

  public List<TrelloBoardDto> mapToDto(final List<TrelloBoard> boards){
    return boards.stream()
                 .map(board -> new TrelloBoardDto(board.getTrelloIdBoard(),
                                                  board.getName(),
                                                  listMapper.mapToDto(board.getLists())))
                 .collect(Collectors.toList());
  }
}
