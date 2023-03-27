package com.example.Trellobackend.dto.card;

public class CardResponse {

    private Integer cardId;
    private String title;
    private String description;

    public CardResponse() {
    }

    public CardResponse(Integer cardId, String title, String description) {
        this.cardId = cardId;
        this.title = title;
        this.description = description;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
