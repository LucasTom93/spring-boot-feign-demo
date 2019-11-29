package com.lukasz.rest.api.books;

import org.springframework.stereotype.Component;

@Component
public class BookFacade {
    private final BookCommandRepository bookCommandRepository;

    public BookFacade(BookCommandRepository bookCommandRepository) {
        this.bookCommandRepository = bookCommandRepository;
    }

    public void save(String title, String author) {
        var bookEntity = BookEntity.of(title, author);
        bookCommandRepository.save(bookEntity);
    }
}
