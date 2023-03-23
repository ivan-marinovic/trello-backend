package com.example.Trellobackend.service;

import com.example.Trellobackend.exception.BoardNotFoundException;
import com.example.Trellobackend.model.Board;
import com.example.Trellobackend.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void addBoard(Board board) {
        boardRepository.save(board);
    }

    public Board getBoardById(Integer boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isPresent()) {
            return optionalBoard.get();
        } else {
            throw new BoardNotFoundException("Board with id " + boardId +  " does not exist");
        }

    }

    public List<Board> getAllBoardsForUser() {
        // TODO: find all boards by user
        return boardRepository.findAll();
    }

    public void deleteBoardById(Integer boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if(optionalBoard.isPresent()) {
            boardRepository.delete(optionalBoard.get());
        } else {
            throw new BoardNotFoundException("Board with id " + boardId +  " does not exist");
        }
    }

}
