package com.lukasz.rest.api.books;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BooksFacadeIntegrationTest {

    @Autowired
    private BookFacade bookFacade;

    @BeforeEach
    void setUp() {
        bookFacade.deleteAll();
    }

    @Test
    void shouldAddBook() {
        //given //when
        var savedBookId = addSimpleBook();

        //then
        assertThat(savedBookId).isNotNull();
    }

    @Test
    void shouldGetAllBooks() {
        //given
        addSimpleBook();
        addSimpleBook();

        //when
        var allBooks = bookFacade.getAll();

        //then
        assertThat(allBooks).isNotEmpty();
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

    private Long addSimpleBook() {
        var title = "Thinking in Java";
        var author = "Bruce Eckel";
        return bookFacade.save(title, author);
    }
}
