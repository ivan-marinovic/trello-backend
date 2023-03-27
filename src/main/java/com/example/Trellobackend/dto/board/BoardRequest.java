package com.example.Trellobackend.dto.board;

public class BoardRequest {

    private String title;

    public BoardRequest() {
    }

    public BoardRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
