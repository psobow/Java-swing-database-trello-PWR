package com.pwr.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBoardDto {
    private String id;
    private String name;
    private List<TrelloListDto> lists;


    @Override
    public String toString(){
        return "Board name: " + name + ", Board ID: " + id +"\n"
                +"      lists inside:\n" + getEveryListToString();
    }

    private String getEveryListToString(){
        String everyList = "";
        if(lists != null) {
            for (TrelloListDto list : this.lists) {
                everyList += "           " + list.toString() + "\n";
            }
        }
        return everyList;
    }

}
