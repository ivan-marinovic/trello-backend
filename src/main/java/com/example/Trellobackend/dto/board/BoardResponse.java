package com.example.Trellobackend.dto.board;

import com.example.Trellobackend.model.TList;

import java.util.List;

public class BoardResponse {
    private Integer boardId;
    private String title;
    private List<TList> lists;

    public BoardResponse() {
    }

    public BoardResponse(Integer boardId, String title, List<TList> lists) {
        this.boardId = boardId;
        this.title = title;
        this.lists = lists;
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

    public List<TList> getLists() {
        return lists;
    }

    public void setLists(List<TList> lists) {
        this.lists = lists;
    }
}
