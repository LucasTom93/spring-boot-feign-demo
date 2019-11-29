package com.lukasz.rest.client.booklibrary;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "books", url = "http://localhost:8098")
interface BookClient {

    @GetMapping("/books/all")
    Set<Book> getAll();
}
