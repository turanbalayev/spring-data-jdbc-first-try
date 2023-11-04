package com.turanbalayev.springdatajdbcfirsttry.repository;

import com.turanbalayev.springdatajdbcfirsttry.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
