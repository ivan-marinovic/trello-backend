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
    private String imageUrl;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "board")
    @JsonIgnore
    private List<com.example.Trellobackend.model.List>lists;

    public Board() {
    }

    public Board(Integer boardId, String title, String imageUrl) {
        this.boardId = boardId;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Board(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<com.example.Trellobackend.model.List> getLists() {
        return lists;
    }

    public void setLists(List<com.example.Trellobackend.model.List> lists) {
        this.lists = lists;
    }
}

