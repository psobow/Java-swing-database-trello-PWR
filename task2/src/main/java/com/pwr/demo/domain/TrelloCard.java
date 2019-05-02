package com.pwr.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrelloCard {
  @NotNull
  @Column(name = "TRELLO_CARD_ID")
  private String trelloIdCard;

  @NotNull
  @Column(name = "TRELLO_LIST_ID")
  private String trelloIdList;

  @NotNull
  @Column(name = "CARD_NAME")
  private String name;

  // PK
  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "ID", unique = true)
  private int id;

  // FK
  @ManyToOne
  @JoinColumn(name = "LIST_ID")
  private TrelloList trelloList;

  private TrelloCard() {}

  public TrelloCard(@NotNull String trelloIdCard, @NotNull String trelloIdList,
                    @NotNull String name) {
    this.trelloIdCard = trelloIdCard;
    this.trelloIdList = trelloIdList;
    this.name = name;
  }
}
