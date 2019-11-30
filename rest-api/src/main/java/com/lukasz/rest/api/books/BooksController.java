package com.lukasz.rest.api.books;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
class BooksController {

    private final BookQueryRepository bookQueryRepository;

    BooksController(BookQueryRepository bookQueryRepository) {
        this.bookQueryRepository = bookQueryRepository;
    }

    @GetMapping("/all")
    Set<BookQueryDto> getAll() {
        return bookQueryRepository.findAll();
    }

    @GetMapping("/search/title/{titleLike}")
    Set<BookQueryDto> searchByTitleLike(@PathVariable String titleLike) {
        return bookQueryRepository.findByTitleLike(titleLike);
    }
}
