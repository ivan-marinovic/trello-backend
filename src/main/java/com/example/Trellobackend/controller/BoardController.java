package com.example.Trellobackend.controller;

import com.example.Trellobackend.dto.board.BoardRequest;
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
    public ResponseEntity<ApiResponse> addNewBoard(@RequestBody BoardRequest boardRequest) {
        boardService.addBoard(boardPresentationService.convertToModel(boardRequest));
        return new ResponseEntity<>(new ApiResponse(1, "Board added successfully!"), HttpStatus.CREATED);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<ApiResponse> updateBoard(@PathVariable("boardId") Integer boardId, @RequestBody BoardRequest boardRequest) {
        boardService.updateBoard(boardId, boardPresentationService.convertToModel(boardRequest));
        return new ResponseEntity<>(new ApiResponse(1, "Board updated successfully!"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<ApiResponse> deleteBoard(@PathVariable("boardId") Integer boardId) {
        boardService.deleteBoardById(boardId);
        return new ResponseEntity<>(new ApiResponse(1, "Board deleted successfully!"), HttpStatus.OK);
    }

}
