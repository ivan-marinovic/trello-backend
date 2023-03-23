package com.example.Trellobackend.dto.list;

public class ListDto {
    private String title;

    public ListDto() {
    }

    public ListDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
