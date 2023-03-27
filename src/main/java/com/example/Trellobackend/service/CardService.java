package com.example.Trellobackend.service;

import com.example.Trellobackend.exception.CardNotFoundException;
import com.example.Trellobackend.exception.TListNotFoundException;
import com.example.Trellobackend.model.Card;
import com.example.Trellobackend.model.TList;
import com.example.Trellobackend.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final ListService listService;

    public CardService(CardRepository cardRepository, ListService listService) {
        this.cardRepository = cardRepository;
        this.listService = listService;
    }

    public void createCard(Integer listId, Card card) {
        Optional<TList> optionalTList = Optional.ofNullable(listService.getListById(listId));
        if(optionalTList.isPresent()) {
            Card newCard = new Card(
                    card.getTitle(),
                    card.getDescription(),
                    optionalTList.get()
            );
            cardRepository.save(newCard);
        } else {
            throw new TListNotFoundException("List with id " + listId + " does not exist");
        }
    }

    public void updateCard(Integer cardId, Card card) {
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if (optionalCard.isPresent()) {
            Card updateCard = optionalCard.get();
            updateCard.setTitle(card.getTitle());
            updateCard.setDescription(card.getDescription());
            cardRepository.save(updateCard);
        } else {
            throw new CardNotFoundException("Card with id " + cardId + " does not exist");
        }
    }
}
