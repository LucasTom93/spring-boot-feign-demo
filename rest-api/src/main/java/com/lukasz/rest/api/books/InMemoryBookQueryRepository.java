package com.lukasz.rest.api.books;

import static com.lukasz.rest.api.books.InMemoryDatabase.MAP_DATABASE;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class InMemoryBookQueryRepository implements QueryRepository {

    @Override
    public Optional<BookQueryDto> findOneById(Long id) {
        var bookEntity = MAP_DATABASE.get(id);
        if (bookEntity == null) {
            return Optional.empty();
        }

        var bookQueryDto = BookQueryDto.of(bookEntity);
        return Optional.of(bookQueryDto);
    }

    @Override
    public Set<BookQueryDto> findAll() {
        return MAP_DATABASE.values()
                .stream()
                .map(BookQueryDto::of)
                .collect(Collectors.toSet());
    }
}
