package com.example.demo;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveBlogpostReository {
    Flux<Blogpost> findAll();
}
