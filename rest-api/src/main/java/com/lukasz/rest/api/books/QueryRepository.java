package com.lukasz.rest.api.books;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
interface QueryRepository extends Repository<BookEntity, Long> {

    @Query("SELECT NEW com.lukasz.rest.api.books.BookQueryDto(be.title, be.author) FROM BookEntity be")
    Set<BookQueryDto> findAll();

    @Query("SELECT NEW com.lukasz.rest.api.books.BookQueryDto(be.title, be.author) FROM BookEntity be WHERE be.id = :id")
    Optional<BookQueryDto> findOneById(@Param("id") Long id);

    @Query("SELECT NEW com.lukasz.rest.api.books.BookQueryDto(be.title, be.author) " +
            "FROM BookEntity be " +
            "WHERE UPPER(be.title) LIKE CONCAT('%', UPPER(:titleLike), '%')")
    Set<BookQueryDto> findByTitleLike(@Param("titleLike") String titleLike);
}
