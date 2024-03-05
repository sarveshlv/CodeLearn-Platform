package com.capg.app.service.FlashcardService;

import com.capg.app.model.Flashcard;
import com.capg.app.repository.FlashcardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFlashcardService implements FlashcardService{

    @Autowired
    private FlashcardRepo flashcardRepo;

    @Override
    public List<Flashcard> getAllCards() {
        return flashcardRepo.findAll();
    }
    @Override
    public List<Flashcard> getAllCardsByCategory(String category) {
        return flashcardRepo.findAllByCategory();
    }

//    public Flashcard createFlashcard(Flashcard card) {
//        return flashcardRepo.save(card);
//    }
    @Override
    public Flashcard getNextFlashcard(String cardId, String knowsAnswer) {
//        List<Flashcard> new_list = getAllCards();
//        int curr_index = 0;
//
//        for(int i=0; i<new_list.size(); i++) {
//            if(new_list.get(i).getId().equals(cardId)) {
//                curr_index = i;
//                break;
//            }
//        }
//        if(knowsAnswer.equals("yes")) {
//            curr_index = (curr_index + 1) %  new_list.size();
//        } else {
//
//        }
//        return new_list.get(curr_index);
        List<Flashcard> currentFlashcards = getAllCards();
        if (currentFlashcards.isEmpty()) {
            currentFlashcards = getAllCards();
        }

        if (cardId != null && knowsAnswer.equals("yes")) {
            currentFlashcards.removeIf(card -> card.getId().equals(cardId));
        }

        if (!currentFlashcards.isEmpty()) {
            return currentFlashcards.remove(0);
        } else {
            currentFlashcards = getAllCards();
            return currentFlashcards.isEmpty() ? null : currentFlashcards.remove(0);
        }
    }
}
