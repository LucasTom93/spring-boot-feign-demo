package com.lukasz.rest.api.books;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
interface CommandRepository extends Repository<BookEntity, Long> {

    BookEntity save(BookEntity bookEntity);

    void deleteAll();
}
