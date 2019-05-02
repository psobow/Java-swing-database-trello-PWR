package com.pwr.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloCardDto {
    @JsonProperty("id")
    private String trelloId;
    @JsonProperty("idList")
    private String trelloListId;
    @JsonProperty("name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Card name: " + name + ", Card ID: " + trelloId + ", List ID: " + trelloListId;
    }
}
