
package com.pwr.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloListDto {
  private String id;
  private String name;
  private Boolean closed;
  private List<TrelloCardDto> cards;

  @Override
  public String toString(){
    return "List name: " + name + ", List ID: " + id + " isClosed: " + closed +"\n"
        + "                Cards inside:\n" + getEveryCardToString();
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCards(List<TrelloCardDto> newCards){
    cards = newCards;
  }

  private String getEveryCardToString(){
    String everyCard = "";
    //Optional.ofNullable(cards).orElse(new ArrayList<>()).stream(); // What to do with it?
    if(cards != null) {
      for (TrelloCardDto card : this.cards) {
        everyCard += "                  " + card.toString() + "\n";
      }
    }
    return everyCard;
  }

  private String getEveryCardToStringVersion2(){
    return Optional.ofNullable(cards)
                   .orElse(new ArrayList<>())
                   .stream()
                   .map(card -> card.toString())
                   .collect(Collectors.joining("\n                  "));
  }
}