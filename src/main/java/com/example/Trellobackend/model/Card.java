package com.example.Trellobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;
    private String title;
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "listId")
    private TList TList;

    public Card() {
    }

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Card(String title, String description, TList tList) {
        this.title = title;
        this.description = description;
        this.TList = tList;
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

    public TList getList() {
        return TList;
    }

    public void setList(TList TList) {
        this.TList = TList;
    }
}
