package com.pwr.demo.domain.DAO;


import com.pwr.demo.domain.TrelloCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TrelloCardDao extends CrudRepository<TrelloCard, Integer> {

}
