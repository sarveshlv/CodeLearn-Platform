package com.capg.app.service;

import com.capg.app.model.Card;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

public interface CardService {
    List<Card> getAllCards();

    Card addCard(Card card);

    Optional<Card> getCardById(String cardId);

    Card getNextFlashcard(String lastCardId, String knowsAnswer);
}
