package cz.steman.spring5demo.repository;

import cz.steman.spring5demo.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {}
