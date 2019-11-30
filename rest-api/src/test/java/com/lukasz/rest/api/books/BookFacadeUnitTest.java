package com.lukasz.rest.api.books;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookFacadeUnitTest {

    private BookFacade bookFacade = new BooksConfiguration().bookFacade();

    @BeforeEach
    void setUp() {
        bookFacade.deleteAll();
    }

    @Test
    void shouldAddBook() {
        //given //when
        var savedBookId = addSimpleBook();

        //then
        assertThat(savedBookId).isOne();
    }

    @Test
    void shouldGetAllBooks() {
        //given
        addSimpleBook();
        addSimpleBook();

        //when
        var allBooks = bookFacade.getAll();

        //then
        assertThat(allBooks.size()).isEqualTo(2);
    }

    @Test
    void shouldReturnEmptySetWhenNoBooks() {
        //given //when
        var allBooks = bookFacade.getAll();

        //then
        assertThat(allBooks).isEmpty();
    }

    @Test
    void shouldGetBookById() {
        //given
        var bookId = addSimpleBook();

        //when
        var bookQueryDto = bookFacade.getBook(bookId);

        //then
        assertThat(bookQueryDto).isNotNull();
    }

    @Test
    void shouldThrowExceptionWhenNoBookFoundById() {
        //given //when //then
        assertThatThrownBy(() -> bookFacade.getBook(1L)).isInstanceOf(NoBookFoundException.class);
    }

    @Test
    void shouldRemoveAllBooks() {
        //given
        addSimpleBook();

        //when
        bookFacade.deleteAll();

        //then
        assertThat(bookFacade.getAll()).isEmpty();
    }

    @Test
    void shouldFindWhenSearchByTitleContainingValue() {
        //given
        var title = "Symfonia C++";
        var author = "Jerzy Grębosz";
        var symphonyBookId = addSimpleBook(title, author);

        //when
        var foundBookSet = bookFacade.searchByTitleContaining("C++");

        //then
        var foundBookOptional = foundBookSet.stream().findFirst();
        assertThat(foundBookOptional).isNotEmpty();
        assertThat(foundBookOptional.get()).extracting(
                BookQueryDto::getTitle,
                BookQueryDto::getAuthor
        ).containsExactly(
                title,
                author
        );
    }

    private Long addSimpleBook() {
        var title = "Thinking in Java";
        var author = "Bruce Eckel";
        return addSimpleBook(title, author);
    }

    private Long addSimpleBook(String title, String author) {
        return bookFacade.save(title, author);
    }
}