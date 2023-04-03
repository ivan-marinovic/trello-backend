package com.example.Trellobackend.dto.board;

import com.example.Trellobackend.dto.list.ListResponse;
import com.example.Trellobackend.model.TList;

import java.util.List;

public class BoardResponse {
    private Integer boardId;
    private String title;
    private List<ListResponse> lists;

    public BoardResponse() {
    }

    public BoardResponse(Integer boardId, String title, List<ListResponse> lists) {
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

    public List<ListResponse> getLists() {
        return lists;
    }

    public void setLists(List<ListResponse> lists) {
        this.lists = lists;
    }
}
