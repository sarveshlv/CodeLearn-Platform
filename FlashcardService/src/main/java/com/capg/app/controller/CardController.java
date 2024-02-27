package com.capg.app.controller;

import com.capg.app.model.Bookmark;
import com.capg.app.model.Card;
import com.capg.app.service.BookmarkService;
import com.capg.app.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;
    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/getAllCards")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping("/addCard")
    public String addCard(@RequestBody Card card) {
        cardService.addCard(card);
        return "Card added!";
    }

    @PostMapping("/answer")
    public Card getNextCard(@RequestParam String lastCardId, @RequestParam String knowsAnswer) {
        return cardService.getNextFlashcard(lastCardId, knowsAnswer);
    }

    @PostMapping("/bookmark")
    public Bookmark addBookMark(@RequestParam String cardId) {
        return bookmarkService.addBookmark(cardId);
    }
}
