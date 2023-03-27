package com.example.Trellobackend.controller;

import com.example.Trellobackend.dto.card.CardRequest;
import com.example.Trellobackend.response.ApiResponse;
import com.example.Trellobackend.service.CardService;
import com.example.Trellobackend.service.presentation.CardPresentationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/card")
public class CardController {

    private final CardService cardService;
    private final CardPresentationService cardPresentationService;

    public CardController(CardService cardService, CardPresentationService cardPresentationService) {
        this.cardService = cardService;
        this.cardPresentationService = cardPresentationService;
    }

    @PostMapping("{listId}")
    public ResponseEntity<ApiResponse> createCard(@PathVariable("listId") Integer listId, @RequestBody CardRequest cardRequest) {
        cardService.createCard(listId, cardPresentationService.convertToModel(cardRequest));
        return new ResponseEntity<>(new ApiResponse(1, "Card created successfully!"), HttpStatus.CREATED);
    }
}
