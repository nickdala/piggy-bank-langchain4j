package com.nickthecloudguy.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@BrowserCallable
@AnonymousAllowed
@Service
@AllArgsConstructor
public class ChatService {

    private CustomerSupportAgent assistant;

    public String chat(String message) {
        return assistant.chat(message);
    }
}
