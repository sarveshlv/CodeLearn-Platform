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
}
