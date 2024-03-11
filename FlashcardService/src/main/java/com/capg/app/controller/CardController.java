package com.capg.app.controller;

import com.capg.app.model.Flashcard;
import com.capg.app.model.UserActivity;
import com.capg.app.service.FlashcardService.FlashcardService;
import com.capg.app.service.UserActivityService.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Flashcard")
public class CardController {
    @Autowired
    private FlashcardService flashcardService;
    @Autowired
    private UserActivityService userActivityService;

    @GetMapping("/getAllCards")
    public List<Flashcard> getAllCards() {
        return flashcardService.getAllCards();
    }
    @PostMapping("/addCard")
    public Flashcard addCard(@RequestBody Flashcard card) {
        return flashcardService.createFlashcard(card);
    }
    @GetMapping("/getCardsByCategory")
    public List<Flashcard> getAllCardsByCategory(@RequestParam String category) {
        return flashcardService.getAllCardsByCategory(category);
    }
    @GetMapping("/getNextCard")
    public Flashcard getNextFlashcard(@RequestParam String cardId, @RequestParam String knowsAnswer) {
        return flashcardService.getNextFlashcard(cardId, knowsAnswer);
    }
    @GetMapping("/getActivityByIdAndStatus")
    public List<UserActivity> getActivityByIdAndStatus(@RequestParam String userId, @RequestParam String status) {
        return userActivityService.getAllCardsByUserIdAndStatus(userId, status);
    }
    @GetMapping("/getActivityByIdAndType")
    public List<UserActivity> getActivityByIdAndType(@RequestParam String userId, @RequestParam String type) {
        return userActivityService.getAllCardsByUserIdAndType(userId, type);
    }
}
