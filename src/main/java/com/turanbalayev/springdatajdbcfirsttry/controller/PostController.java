package com.turanbalayev.springdatajdbcfirsttry.controller;


import com.turanbalayev.springdatajdbcfirsttry.model.Author;
import com.turanbalayev.springdatajdbcfirsttry.model.Post;
import com.turanbalayev.springdatajdbcfirsttry.model.dto.PostDetailsDto;
import com.turanbalayev.springdatajdbcfirsttry.repository.AuthorRepository;
import com.turanbalayev.springdatajdbcfirsttry.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository posts;
    private final AuthorRepository authors;

    @Autowired
    public PostController(PostRepository posts, AuthorRepository authors) {
        this.posts = posts;
        this.authors = authors;
    }

    @GetMapping
    public Iterable<Post> findAll(){
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id){
        return posts.findById(id).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/{id}/details")
    public PostDetailsDto getPostDetails(@PathVariable Integer id){
        Post post = posts.findById(id).orElseThrow(RuntimeException::new);
        Author author = authors.findById(post.getAuthor().getId()).orElseThrow(RuntimeException::new);

        return new PostDetailsDto(post,author);
    }


}
