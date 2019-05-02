package com.pwr.demo.domain;

import com.pwr.demo.DemoApplication;
import com.pwr.demo.client.TrelloClient;
import com.pwr.demo.domain.DAO.TrelloBoardDao;
import com.pwr.demo.mapper.BoardMapper;
import com.pwr.demo.service.DBservice;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// Przed testami trzeba zakomentować anotacje @Component w klasie MainFrame

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TrelloBoardTest {
  @Autowired
  TrelloClient client;
  @Autowired
  BoardMapper boardMapper;
  @Autowired
  DBservice dBservice;
  @Autowired
  TrelloBoardDao boardDao;

  @Test
  public void testBoardSave(){
    // Given
    List<TrelloBoard> boards = boardMapper.mapToDomain(client.getTrelloBoardsWithListsAndCards());



    // When
    dBservice.saveAll(boards);

    // Cleaning

    // Then
  }

  @Test
  public void deleteBoards(){
    boardDao.deleteAll();
  }
}