package com.example.Trellobackend.service.presentation;

import com.example.Trellobackend.dto.list.ListRequest;
import com.example.Trellobackend.dto.list.ListResponse;
import com.example.Trellobackend.model.TList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPresentationService {

    private final CardPresentationService cardPresentationService;

    public ListPresentationService(CardPresentationService cardPresentationService) {
        this.cardPresentationService = cardPresentationService;
    }

    public TList convertToModel(ListRequest listRequest) {
        return new TList(
                listRequest.getTitle()
        );
    }

    public ListResponse convertToDto(TList tList) {
        return new ListResponse(
                tList.getListId(),
                tList.getTitle(),
                cardPresentationService.convertToDtoList(tList.getCards())
        );
    }

    public List<ListResponse> convertToDtoList(List<TList> tLists) {
        return tLists.stream().map(this::convertToDto).toList();
    }
}
