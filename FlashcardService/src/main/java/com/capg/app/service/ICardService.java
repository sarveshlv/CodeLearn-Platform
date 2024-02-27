package com.capg.app.service;

import com.capg.app.model.Card;
import com.capg.app.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ICardService implements CardService {

    @Autowired
    private CardRepository cardRepository;

    private List<Card> allFlashCards = new ArrayList<>();

    public void initializeCardList() {
        allFlashCards.addAll(getAllCards());
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Optional<Card> getCardById(String cardId) {
        return cardRepository.findById(cardId);
    }















    //The logic needs to be changed, this is just a queue simulation (checked)
    @Override
    public Card getNextFlashcard(String lastCardId, String knowsAnswer) {
        if(allFlashCards.isEmpty()) {
            initializeCardList();
        }

        int currentIndex = 0;
        for (int i = 0; i < allFlashCards.size(); i++) {
            if (allFlashCards.get(i).getId().equals(lastCardId)) {
                currentIndex = i;
                break;
            }
        }

        if(knowsAnswer.equals("yes")) {
            allFlashCards.remove(allFlashCards.get(currentIndex));
            if(allFlashCards.isEmpty()) {
                initializeCardList();
                return allFlashCards.get(0);
            }
        } else {
            currentIndex = (currentIndex+1) % allFlashCards.size();
        }
        System.out.println(allFlashCards);
        return allFlashCards.get(currentIndex);
    }
}
