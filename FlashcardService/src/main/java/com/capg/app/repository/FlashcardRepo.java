package com.capg.app.repository;

import com.capg.app.model.Flashcard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashcardRepo extends MongoRepository<Flashcard, String> {
    List<Flashcard> findAllByCategory();
}
