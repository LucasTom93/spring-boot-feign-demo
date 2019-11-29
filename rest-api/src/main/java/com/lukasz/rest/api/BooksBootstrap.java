package com.lukasz.rest.api;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lukasz.rest.api.books.BookFacade;

@Component
class BooksBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final BookFacade bookFacade;

    BooksBootstrap(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        bookFacade.save("DDD", "Eric evans");
        bookFacade.save("Thinking in Java", "Bruce Eckel");
    }
}
