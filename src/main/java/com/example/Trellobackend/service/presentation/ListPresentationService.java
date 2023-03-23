package com.example.Trellobackend.service.presentation;

import com.example.Trellobackend.dto.board.BoardDto;
import com.example.Trellobackend.dto.board.BoardResponse;
import com.example.Trellobackend.dto.list.ListDto;
import com.example.Trellobackend.dto.list.ListResponse;
import com.example.Trellobackend.model.Board;
import com.example.Trellobackend.model.TList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPresentationService {

    public TList convertToModel(ListDto listDto) {
        return new TList(
                listDto.getTitle()
        );
    }

    public ListResponse convertToDto(TList tList) {
        return new ListResponse(
                tList.getListId(),
                tList.getTitle(),
                tList.getCards()
        );
    }

    public List<ListResponse> convertToDtoList(List<TList> tLists) {
        return tLists.stream().map(this::convertToDto).toList();
    }
}
