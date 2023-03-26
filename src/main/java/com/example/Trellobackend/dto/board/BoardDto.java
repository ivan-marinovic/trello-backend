package com.example.Trellobackend.dto.board;

public class BoardDto {

    private String title;

    public BoardDto() {
    }

    public BoardDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
