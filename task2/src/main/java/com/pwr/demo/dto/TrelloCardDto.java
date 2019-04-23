package com.pwr.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloCardDto {
    private String id;
    private String idList;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Card name: " + name + ", Card ID: " + id + ", List ID: " + idList;
    }
}
