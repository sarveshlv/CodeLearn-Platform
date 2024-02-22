package com.capg.app.service;

import com.capg.app.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();

    Card addCard(Card card);

    Card getNextFlashcard(String lastCardId, String knowsAnswer);
}
