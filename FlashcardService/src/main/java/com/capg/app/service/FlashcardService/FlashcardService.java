package com.capg.app.service.FlashcardService;

import com.capg.app.model.Flashcard;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FlashcardService {
    List<Flashcard> getAllCards();

    List<Flashcard> getAllCardsByCategory(String category);
}
