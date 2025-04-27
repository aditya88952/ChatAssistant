package com.example.chatgptclone.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ChatService {

    private final WebClient webClient;

    public ChatService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer YOUR_OPENAI_API_KEY")
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

