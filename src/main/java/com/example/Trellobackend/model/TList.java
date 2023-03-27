package com.example.Trellobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class TList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listId;
    private String title;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "boardId")
    private Board board;

    @OneToMany(mappedBy = "TList",  cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Card> cards;

    public TList() {
    }

    public TList(String title, Board board) {
        this.title = title;
        this.board = board;
    }

    public TList(String title) {
        this.title = title;
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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public java.util.List<Card> getCards() {
        return cards;
    }

    public void setCards(java.util.List<Card> cards) {
        this.cards = cards;
    }
}

