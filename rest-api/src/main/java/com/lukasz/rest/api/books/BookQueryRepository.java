package com.lukasz.rest.api.books;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
interface BookQueryRepository extends Repository<BookEntity, Long> {

    @Query("SELECT NEW com.lukasz.rest.api.books.BookQueryDto(be.title, be.author) FROM BookEntity be")
    Set<BookQueryDto> findAll();
}
