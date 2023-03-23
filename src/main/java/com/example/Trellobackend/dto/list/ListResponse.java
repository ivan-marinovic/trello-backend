package com.example.Trellobackend.dto.list;

import com.example.Trellobackend.model.Card;

import java.util.List;

public class ListResponse {
    private Integer listId;
    private String title;
    private List<Card> cards;

    public ListResponse() {
    }

    public ListResponse(Integer listId, String title, List<Card> cards) {
        this.listId = listId;
        this.title = title;
        this.cards = cards;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
