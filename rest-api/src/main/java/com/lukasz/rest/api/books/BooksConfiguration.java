package com.lukasz.rest.api.books;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BooksConfiguration {

    BookFacade bookFacade() {
        return new BookFacade(new InMemoryBookCommandRepository(), new InMemoryBookQueryRepository());
    }

    @Bean
    BookFacade bookFacade(CommandRepository commandRepository, QueryRepository queryRepository) {
        return new BookFacade(commandRepository, queryRepository);
    }
}
