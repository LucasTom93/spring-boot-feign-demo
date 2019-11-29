package com.lukasz.rest.api.books;

import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
interface BookCommandRepository extends Repository<BookEntity, Long> {

    BookEntity save(BookEntity bookEntity);
}
