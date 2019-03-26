package com.pwr.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    public void setCards(List<TrelloCardDto> newCards){
        cards = newCards;
    }

    private String getEveryCardToString(){
        String everyCard = "";
        if(cards != null) {
            for (TrelloCardDto card : this.cards) {
                everyCard += "                  " + card.toString() + "\n";
            }
        }
        return everyCard;
    }
}
