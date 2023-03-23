package com.example.Trellobackend.service;

import com.example.Trellobackend.exception.BoardNotFoundException;
import com.example.Trellobackend.model.Board;
import com.example.Trellobackend.model.TList;
import com.example.Trellobackend.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {

    private final ListRepository listRepository;
    private final BoardService boardService;

    public ListService(ListRepository listRepository, BoardService boardService) {
        this.listRepository = listRepository;
        this.boardService = boardService;
    }

    public void addNewList(Integer boardId, TList tList) {
        Optional<Board> board = Optional.ofNullable(boardService.getBoardById(boardId));
        if(board.isPresent()) {
            TList newTList = new TList(
                    tList.getTitle(),
                    board.get()
            );
            listRepository.save(newTList);
        } else {
            throw new BoardNotFoundException("Board with id " + boardId + " does not exist");
        }
    }

    public List<TList> getAllListsForBoard(Integer boardId) {
        Optional<Board> board = Optional.ofNullable(boardService.getBoardById(boardId));
        if (board.isEmpty()) {
            throw new BoardNotFoundException("Board with id " + boardId + " does not exist");
        } else {
            return listRepository.findAllByBoard(board.get());
        }
    }

}
