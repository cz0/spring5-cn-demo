package cz.steman.spring5demo.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;
import java.util.Collections;

@Configuration
public class ClientConf {
    private static final String DOMAIN = "https://slack.com";
    private static final String PATH = "/api/users.list";

    @Value("${token}")
    private String token;

    @Bean
    WebClient client() {
        return WebClient.create(DOMAIN);
    }

    @Bean
    URI uri() {
        return new DefaultUriBuilderFactory(DOMAIN + PATH)
                .uriString("?token={token}")
                .build(Collections.singletonMap("token", token));
    }
}
