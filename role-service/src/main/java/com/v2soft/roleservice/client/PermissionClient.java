package com.v2soft.roleservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PermissionClient {

    private final WebClient webClient;

    public PermissionClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081").build();
    }

    public PermissionDTO getPermissionById(Long id) {
        return webClient.get()
                .uri("/permissions/" + id)
                .retrieve()
                .bodyToMono(PermissionDTO.class)
                .block();
    }
}
