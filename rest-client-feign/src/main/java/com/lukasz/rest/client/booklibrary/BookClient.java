package com.lukasz.rest.client.booklibrary;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "books", url = "http://localhost:8098")
interface BookClient {

    @GetMapping("/books/all")
    Set<Book> getAll();

    @GetMapping("/books/book/{bookId}")
    Book getById(@PathVariable Long bookId);

    @GetMapping("/books/search/title/{titleLike}")
    Set<Book> getByTitleLike(@PathVariable String titleLike);
}
