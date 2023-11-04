package com.turanbalayev.springdatajdbcfirsttry.model.dto;

import com.turanbalayev.springdatajdbcfirsttry.model.Author;
import com.turanbalayev.springdatajdbcfirsttry.model.Post;

public record PostDetailsDto(Post post, Author author) {
}
