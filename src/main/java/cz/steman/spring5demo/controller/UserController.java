package cz.steman.spring5demo.controller;

import cz.steman.spring5demo.model.User;
import cz.steman.spring5demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Mono<User> byId(@PathVariable String id) {
        return userService.byId(id);
    }

    @GetMapping
    public Flux<User> all() {
        return userService.all();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> stream() {
        return userService.stream();
    }
}