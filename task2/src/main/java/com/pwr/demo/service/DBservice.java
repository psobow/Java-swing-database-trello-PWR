package com.pwr.demo.service;

import com.pwr.demo.domain.DAO.TrelloBoardDao;
import com.pwr.demo.domain.TrelloBoard;
import com.pwr.demo.domain.TrelloCard;
import com.pwr.demo.domain.TrelloList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DBservice {
  @Autowired
  TrelloBoardDao boardDao;

  public void saveAll(final List<TrelloBoard> boards){
    for(TrelloBoard board : boards){
      for(TrelloList list : board.getLists()){
        list.setTrelloBoard(board);
        for(TrelloCard card : list.getCards()){
          card.setTrelloList(list);
        }
      }
    }
    boardDao.saveAll(boards);
  }

  public void deleteAll(){
    boardDao.deleteAll();
  }

  public List<TrelloBoard> findAll(){
    return boardDao.findAll();
  }
}
