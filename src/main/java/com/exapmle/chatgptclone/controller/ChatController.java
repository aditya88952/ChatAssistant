package com.example.chatgptclone.controller;

import com.example.chatgptclone.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {
        return chatService.getChatResponse(prompt);
    }
}

