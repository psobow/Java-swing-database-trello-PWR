package com.pwr.demo.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrelloList {

  @NotNull
  @Column(name = "TRELLO_LIST_ID")
  private String trelloIdList;

  @NotNull
  @Column(name = "LIST_NAME")
  private String name;


  // PK
  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "ID", unique = true)
  private int id;

  // FK
  @ManyToOne
  @JoinColumn(name = "BOARD_ID")
  private TrelloBoard trelloBoard;

  @OneToMany(targetEntity = TrelloCard.class,
             mappedBy = "trelloList",
             cascade = CascadeType.ALL,
             fetch = FetchType.EAGER)
  private List<TrelloCard> cards = new ArrayList<>();

  private TrelloList() {}

  public TrelloList(@NotNull String trelloIdList, @NotNull String name,
                    List<TrelloCard> cards) {
    this.trelloIdList = trelloIdList;
    this.name = name;
    this.cards = cards;
  }
}
