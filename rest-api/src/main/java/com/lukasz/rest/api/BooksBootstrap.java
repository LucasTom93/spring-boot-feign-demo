package com.lukasz.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.lukasz.rest.api.books.BookFacade;

@Component
class BooksBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BooksBootstrap.class);
    private final BookFacade bookFacade;

    BooksBootstrap(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Long dddId = bookFacade.save("DDD", "Eric evans");
        Long thinkingInJavaId = bookFacade.save("Thinking in Java", "Bruce Eckel");
        LOGGER.info("Saved two books of id: {} and {}", dddId, thinkingInJavaId);
    }
}
