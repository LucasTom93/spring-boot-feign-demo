package com.lukasz.rest.client.booklibrary;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/books")
class BooksLibraryController {

    private final BookClient bookClient;

    BooksLibraryController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @GetMapping("/all")
    Set<Book> getAll() {
        return bookClient.getAll();
    }

    @GetMapping("/book/{bookId}")
    Book getById(@PathVariable Long bookId) {
        return bookClient.getById(bookId);
    }

    @GetMapping("/search/title/{titleLike}")
    Set<Book> searchByTitleLike(@PathVariable String titleLike) {
        return bookClient.getByTitleLike(titleLike);
    }
}
