package com.turanbalayev.springdatajdbcfirsttry;

import com.turanbalayev.springdatajdbcfirsttry.model.Author;
import com.turanbalayev.springdatajdbcfirsttry.model.Comment;
import com.turanbalayev.springdatajdbcfirsttry.model.Post;
import com.turanbalayev.springdatajdbcfirsttry.repository.AuthorRepository;
import com.turanbalayev.springdatajdbcfirsttry.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class SpringDataJdbcFirstTryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcFirstTryApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, AuthorRepository authors) {
        return args -> {
            AggregateReference<Author, Integer> turan = AggregateReference.to(authors.save(new Author(
                    null,
                    "Turan",
                    "Balayev",
                    "turan_balayev@gmail.com",
                    "turanbalayev")).id());

            Post post = new Post("Hello World!", "Welcome to my blog!", turan);

            post.addComment(new Comment("Terry","This article is very useful. I loved it!"));
            post.addComment(new Comment("Jimmy","This article is very good. I liked it!"));

            posts.save(post);


        };
    }

}
