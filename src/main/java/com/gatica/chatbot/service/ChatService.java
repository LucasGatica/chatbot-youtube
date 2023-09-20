package com.gatica.chatbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatica.chatbot.controller.request.ChatRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ChatService {

    private final String AUTHORIZATION = "Bearer ";
    private final String URL = "https://api.openai.com/v1/chat/completions";

    public String sendMessage(ChatRequest chatRequest) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", AUTHORIZATION);
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        ObjectMapper objectMapper = new ObjectMapper();

        String requestBody = objectMapper.writeValueAsString(chatRequest);

        RequestEntity<String> requestEntity =
                RequestEntity
                        .post(URL)
                        .headers(headers)
                        .body(requestBody);

        return restTemplate.exchange(requestEntity, String.class).getBody();
    }
}
