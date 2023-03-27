package com.example.Trellobackend.service.presentation;

import com.example.Trellobackend.dto.board.BoardRequest;
import com.example.Trellobackend.dto.board.BoardResponse;
import com.example.Trellobackend.dto.card.CardRequest;
import com.example.Trellobackend.dto.card.CardResponse;
import com.example.Trellobackend.model.Board;
import com.example.Trellobackend.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardPresentationService {

    public Card convertToModel(CardRequest cardRequest) {
        return new Card(
                cardRequest.getTitle(),
                cardRequest.getDescription()
        );

    }

    public CardResponse convertToDto(Card card) {
        return new CardResponse(
                card.getCardId(),
                card.getTitle(),
                card.getDescription()
        );
    }

    public List<CardResponse> convertToDtoList(List<Card> cards) {
        return cards.stream().map(this::convertToDto).toList();
    }
}
