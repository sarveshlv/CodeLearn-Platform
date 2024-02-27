package com.capg.app.service;

import com.capg.app.model.Bookmark;
import org.springframework.stereotype.Service;

public interface BookmarkService {
    Bookmark addBookmark(String cardId);
}
