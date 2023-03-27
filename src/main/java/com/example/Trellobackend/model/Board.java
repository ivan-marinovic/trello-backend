package com.example.Trellobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId;
    private String title;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "board",  cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TList> TLists;

    public Board() {
    }

    public Board(Integer boardId, String title, String imageUrl) {
        this.boardId = boardId;
        this.title = title;
    }

    public Board(String title) {
        this.title = title;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TList> getLists() {
        return TLists;
    }

    public void setLists(List<TList> TLists) {
        this.TLists = TLists;
    }
}

