package com.example.Trellobackend.service.presentation;

import com.example.Trellobackend.dto.board.BoardRequest;
import com.example.Trellobackend.dto.board.BoardResponse;
import com.example.Trellobackend.model.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardPresentationService {

    private final ListPresentationService listPresentationService;

    public BoardPresentationService(ListPresentationService listPresentationService) {
        this.listPresentationService = listPresentationService;
    }

    public Board convertToModel(BoardRequest boardRequest) {
        return new Board(
                boardRequest.getTitle()
        );

    }

    public BoardResponse convertToDto(Board board) {
        return new BoardResponse(
                board.getBoardId(),
                board.getTitle(),
                listPresentationService.convertToDtoList(board.getLists())
        );
    }

    public List<BoardResponse> convertToDtoList(List<Board> boards) {
        return boards.stream().map(this::convertToDto).toList();
    }

}
