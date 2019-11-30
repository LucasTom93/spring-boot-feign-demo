package com.lukasz.rest.api.books;

import java.util.Optional;
import java.util.Set;

public class BookFacade {
    private final CommandRepository commandRepository;
    private final QueryRepository queryRepository;

    public BookFacade(CommandRepository commandRepository, QueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    public Long save(String title, String author) {
        var bookEntity = BookEntity.of(title, author);
        return commandRepository.save(bookEntity).getId();
    }

    public BookQueryDto getBook(Long id) {
        Optional<BookQueryDto> bookQueryDtoOptional = queryRepository.findOneById(id);
        return bookQueryDtoOptional.orElseThrow(NoBookFoundException::new);
    }

    public Set<BookQueryDto> getAll() {
        return queryRepository.findAll();
    }

    public void deleteAll() {
        commandRepository.deleteAll();
    }

    public Set<BookQueryDto> searchByTitleContaining(String searchValue) {
        return queryRepository.findByTitleLike(searchValue);
    }
}
