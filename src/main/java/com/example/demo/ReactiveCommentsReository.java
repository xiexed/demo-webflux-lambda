package com.example.demo;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactiveCommentsReository {
    Flux<String> findComments(int id);
}
