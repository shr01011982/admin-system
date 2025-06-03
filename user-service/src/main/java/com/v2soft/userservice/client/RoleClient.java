package com.v2soft.userservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class RoleClient {

    private final WebClient webClient;

    public RoleClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8082").build(); // role-service
    }

    public RoleDTO getRoleById(Long roleId) {
        return webClient.get()
                .uri("/roles/" + roleId)
                .retrieve()
                .bodyToMono(RoleDTO.class)
                .block();
    }
}
