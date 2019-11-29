package com.lukasz.rest.api.books;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryDatabase {
    static Map<Long, BookEntity> MAP_DATABASE = new ConcurrentHashMap<>();
}
