package com.example.Trellobackend.model;

import jakarta.persistence.*;

@Entity
@Table
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listId;
    private String title;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @OneToMany(mappedBy = "list")
    private java.util.List<Card> cards;

    public List() {
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
