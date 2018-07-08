package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @Autowired
    ReactiveBlogpostReository blogpostReository;

    @Autowired
    ReactiveCommentsReository commentsReository;

    @GetMapping("/firstComments")
    public Flux<String> allComments() {
        return blogpostReository.findAll().flatMap(post -> {
            String first = commentsReository.findComments(post.getId()).blockFirst();
            return Mono.justOrEmpty(first);
        });
    }

}
