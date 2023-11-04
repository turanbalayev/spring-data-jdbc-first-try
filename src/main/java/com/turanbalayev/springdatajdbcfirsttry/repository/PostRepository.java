package com.turanbalayev.springdatajdbcfirsttry.repository;

import com.turanbalayev.springdatajdbcfirsttry.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {

}
