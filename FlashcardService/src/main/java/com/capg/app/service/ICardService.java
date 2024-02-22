package com.capg.app.service;

import com.capg.app.model.Card;
import com.capg.app.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICardService implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    //The logic needs to be changed, this is just a queue simulation (checked)
    @Override
    public Card getNextFlashcard(String lastCardId, String knowsAnswer) {
        List<Card> allFlashcards = getAllCards();
        int currentIndex = 0;

        for (int i = 0; i < allFlashcards.size(); i++) {
            if (allFlashcards.get(i).getId().equals(lastCardId)) {
                currentIndex = i;
                break;
            }
        }

        if (knowsAnswer.equals("yes")) {
            currentIndex = (currentIndex + 1) % allFlashcards.size();
        }

        return allFlashcards.get(currentIndex);
    }
}
