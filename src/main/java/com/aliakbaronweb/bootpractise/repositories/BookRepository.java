package com.aliakbaronweb.bootpractise.repositories;

import com.aliakbaronweb.bootpractise.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
