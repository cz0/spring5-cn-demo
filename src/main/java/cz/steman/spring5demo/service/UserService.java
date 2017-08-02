package cz.steman.spring5demo.service;

import cz.steman.spring5demo.model.User;
import cz.steman.spring5demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> all() {
        return userRepository.findAll();
    }

    public Mono<User> byId(String id) {
        return userRepository.findById(id);
    }

    public Flux<User> stream() {
        return Flux
                .zip(Flux.interval(Duration.ofSeconds(1)), all())
                .map(Tuple2::getT2);
    }
}