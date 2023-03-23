package com.example.Trellobackend.dto.board;

public class BoardResponse {
    private Integer boardId;
    private String title;
    private String imageUrl;

    public BoardResponse(Integer boardId, String title, String imageUrl) {
        this.boardId = boardId;
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
}
