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
    public Set<BookQueryDto> findByTitleLike(String titleLike) {
        return MAP_DATABASE.values()
                .stream()
                .filter(bookEntity -> foo(bookEntity, titleLike))
                .map(BookQueryDto::of)
                .collect(Collectors.toSet());
    }

    private boolean foo(BookEntity bookEntity, String titleLike) {
        boolean isSearchTitleEmpty = titleLike.equals("");
        if (isSearchTitleEmpty) {
            return true;
        } else {
            return bookEntity.getTitle()
                    .toUpperCase()
                    .contains(titleLike.toUpperCase());
        }
    }

    @Override
    public Set<BookQueryDto> findAll() {
        return MAP_DATABASE.values()
                .stream()
                .map(BookQueryDto::of)
                .collect(Collectors.toSet());
    }
}
