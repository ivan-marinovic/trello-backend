package com.example.Trellobackend.controller;

import com.example.Trellobackend.dto.list.ListRequest;
import com.example.Trellobackend.dto.list.ListResponse;
import com.example.Trellobackend.response.ApiResponse;
import com.example.Trellobackend.service.ListService;
import com.example.Trellobackend.service.presentation.ListPresentationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/list")
public class ListController {

    private final ListService listService;
    private final ListPresentationService listPresentationService;

    public ListController(ListService listService, ListPresentationService listPresentationService) {
        this.listService = listService;
        this.listPresentationService = listPresentationService;
    }

    @GetMapping("/{boardId}")
    public List<ListResponse> getAllListsForBoard(@PathVariable("boardId") Integer boardId) {
        return listPresentationService.convertToDtoList(listService.getAllListsForBoard(boardId));
    }

    @PostMapping("/{boardId}")
    public ResponseEntity<ApiResponse> createNewList(@PathVariable("boardId") Integer boardId, @RequestBody ListRequest listRequest) {
        listService.addNewList(boardId, listPresentationService.convertToModel(listRequest));
        return new ResponseEntity<>(new ApiResponse(1, "List created successfully!"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{listId}")
    public ResponseEntity<ApiResponse> deleteList(@PathVariable("listId") Integer listId) {
        listService.deleteListById(listId);
        return new ResponseEntity<>(new ApiResponse(1, "List deleted successfully!"), HttpStatus.OK);
    }
}
