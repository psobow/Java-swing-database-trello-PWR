package com.pwr.demo.domain.DAO;

import com.pwr.demo.domain.TrelloList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TrelloListDao extends CrudRepository<TrelloList, Integer> {

}
