package com.pwr.demo.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrelloBoard {
  @NotNull
  @Column(name = "BOARD_NAME")
  private String name;

  @NotNull
  @Column(name = "TRELLO_BOARD_ID")
  private String trelloIdBoard;

  // PK
  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "ID", unique = true)
  private int id;

  // FK
  @OneToMany(targetEntity = TrelloList.class,
             mappedBy = "trelloBoard",
             cascade = CascadeType.ALL,
             fetch = FetchType.EAGER)
  private List<TrelloList> lists = new ArrayList<>();

  private TrelloBoard() {}

  public TrelloBoard(@NotNull String trelloIdBoard, @NotNull String name,
                     List<TrelloList> lists) {
    this.name = name;
    this.trelloIdBoard = trelloIdBoard;
    this.lists = lists;
  }
}
