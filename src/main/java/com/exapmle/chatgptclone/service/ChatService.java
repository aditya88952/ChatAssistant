package com.example.chatgptclone.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ChatService {

    private final WebClient webClient;

    public ChatService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer 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")
                .build();
    }

    public String getChatResponse(String prompt) {
        String requestBody = """
        {
          "model": "gpt-3.5-turbo",
          "messages": [{"role": "user", "content": "%s"}]
        }
        """.formatted(prompt);

        return webClient.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

