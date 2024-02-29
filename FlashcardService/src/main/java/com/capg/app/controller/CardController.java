package com.capg.app.controller;

import com.capg.app.service.FlashcardService.FlashcardService;
import com.capg.app.service.UserActivityService.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Flashcard")
public class CardController {
    @Autowired
    private FlashcardService flashcardService;
    @Autowired
    private UserActivityService userActivityService;
}
