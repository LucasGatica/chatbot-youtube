package com.gatica.chatbot.controller.request;



import com.gatica.chatbot.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
    private List<Message> messages;
    private String model;

}
