package com.lukasz.rest.api.books;

class BookQueryDto {
    private String title;
    private String author;

    BookQueryDto() {
        //for Jackson
    }

    public BookQueryDto(String title, String author) {
        this.title = title;
        this.author = author;
    }

    static BookQueryDto of(BookEntity bookEntity) {
        String title = bookEntity.getTitle();
        String author = bookEntity.getAuthor();
        return new BookQueryDto(title, author);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
