package com.pwr.demo.domain.DAO;

import com.pwr.demo.domain.TrelloBoard;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TrelloBoardDao extends CrudRepository<TrelloBoard, Integer> {
  @Override
  List<TrelloBoard> findAll();
}
