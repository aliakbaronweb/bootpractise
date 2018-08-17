package com.aliakbaronweb.bootpractise.repositories;

import com.aliakbaronweb.bootpractise.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
