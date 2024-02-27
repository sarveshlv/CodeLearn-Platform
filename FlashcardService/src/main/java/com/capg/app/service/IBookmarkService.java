package com.capg.app.service;

import com.capg.app.model.Bookmark;
import com.capg.app.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookmarkService implements BookmarkService{
    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Override
    public Bookmark addBookmark(String cardId) {
        Bookmark card = new Bookmark();
        card.setCardId(cardId);
        return bookmarkRepository.save(card);
    }
}
