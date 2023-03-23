package com.example.Trellobackend.controller;

import com.example.Trellobackend.dto.board.BoardDto;
import com.example.Trellobackend.dto.board.BoardResponse;
import com.example.Trellobackend.model.Board;
import com.example.Trellobackend.response.ApiResponse;
import com.example.Trellobackend.service.BoardService;
import com.example.Trellobackend.service.presentation.BoardPresentationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardPresentationService boardPresentationService;

    public BoardController(BoardService boardService, BoardPresentationService boardPresentationService) {
        this.boardService = boardService;
        this.boardPresentationService = boardPresentationService;
    }

    @GetMapping
    public List<BoardResponse> getAllBoardsForUser() {
        // TODO: get user
        List<Board> boards = boardService.getAllBoardsForUser();
        return boardPresentationService.convertToDtoList(boards);
    }

    @GetMapping("/{boardId}")
    public BoardResponse getBoard(@PathVariable("boardId") Integer boardId) {
        // TODO: get user
        Board board = boardService.getBoardById(boardId);
        return boardPresentationService.convertToDto(board);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addNewBoard(@RequestBody BoardDto boardDto) {
        boardService.addBoard(boardPresentationService.convertToModel(boardDto));
        return new ResponseEntity<>(new ApiResponse(1, "Board added successfully!"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<ApiResponse> deleteBoard(@PathVariable("boardId") Integer boardId) {
        boardService.deleteBoardById(boardId);
        return new ResponseEntity<>(new ApiResponse(1, "Board deleted successfully!"), HttpStatus.OK);
    }

}
