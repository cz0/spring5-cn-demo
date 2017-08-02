package cz.steman.spring5demo;

import cz.steman.spring5demo.model.SlackMessage;
import cz.steman.spring5demo.model.User;
import cz.steman.spring5demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URI;

@SpringBootApplication
public class JsonDeserializerClientApplication {


    @Bean
    CommandLineRunner saveData(WebClient client, URI uri, UserRepository repository) {
        Flux<User> users = client
                .get()
                .uri(uri)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(SlackMessage.class))
                .flatMapMany(message -> Flux.fromIterable(message.getMembers()));

        return args ->
                repository
                        .deleteAll()
                        .subscribe(null, null, () -> {
                            System.out.println("Hello world");
                            users.subscribe(user -> {
                                System.out.println(user);
                                repository.save(user).subscribe(System.out::println);});
                        });

    }

    public static void main(String[] args) {
        SpringApplication.run(JsonDeserializerClientApplication.class, args);
    }
}


