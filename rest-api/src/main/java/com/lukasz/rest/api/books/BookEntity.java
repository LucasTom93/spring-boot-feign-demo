package com.lukasz.rest.api.books;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class BookEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;

    BookEntity() {
        //for JPA
    }

    private BookEntity(String title, String author) {
        this.title = title;
        this.author = author;
    }

    static BookEntity of(String title, String author) {
        return new BookEntity(title, author);
    }
}
