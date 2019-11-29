package com.lukasz.rest.api.books;

import static com.lukasz.rest.api.books.InMemoryDatabase.MAP_DATABASE;

class InMemoryBookCommandRepository implements CommandRepository {

    @Override
    public BookEntity save(BookEntity bookEntity) {
        ensureNotNullId(bookEntity);
        MAP_DATABASE.putIfAbsent(bookEntity.getId(), bookEntity);
        return bookEntity;
    }

    @Override
    public void deleteAll() {
        MAP_DATABASE.clear();
    }

    private void ensureNotNullId(BookEntity bookEntity) {
        if (bookEntity.getId() == null) {
            long nextId;
            if (MAP_DATABASE.isEmpty()) {
                nextId = 1L;
            } else {
                nextId = MAP_DATABASE.keySet().stream().max(Long::compareTo).get() + 1;
            }
            bookEntity.setId(nextId);
        }
    }
}
