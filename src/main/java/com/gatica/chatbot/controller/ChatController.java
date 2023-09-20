package com.gatica.chatbot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gatica.chatbot.controller.request.ChatRequest;
import com.gatica.chatbot.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/chatbot")
@AllArgsConstructor
public class ChatController {

    private ChatService chatService;

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody ChatRequest chatRequest) throws JsonProcessingException {
        System.out.println("entrou");
        return chatService.sendMessage(chatRequest);

    }
}
