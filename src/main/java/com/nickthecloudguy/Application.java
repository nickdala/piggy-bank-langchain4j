package com.nickthecloudguy;

import com.nickthecloudguy.services.CustomerSupportAgent;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "piggy-bank-langchain4j")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CustomerSupportAgent customerSupportAgent(ChatLanguageModel chatLanguageModel) {
        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(20);

        return AiServices.builder(CustomerSupportAgent.class)
            .chatLanguageModel(chatLanguageModel)
            .chatMemory(chatMemory)
            .build();
    }

}
