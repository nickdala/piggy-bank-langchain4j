package com.nickthecloudguy;

import com.nickthecloudguy.services.CustomerSupportAgent;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CustomerSupportAgent customerSupportAgent(
        @Value("${openai.api-key}") String openaiApiKey,
        @Value("${azureopenai.api-key}") String azureApiKey,
        @Value("${azureopenai.endpoint}") String azureEndpoint) {

                log.info("OpenAI API Key: {}", openaiApiKey);
                log.info("Azure OpenAI API Key: {}", azureApiKey);
                log.info("Azure OpenAI Endpoint: {}", azureEndpoint);

                ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(20);
                ChatLanguageModel model = OpenAiChatModel.withApiKey(openaiApiKey);

                return AiServices.builder(CustomerSupportAgent.class)
                    .chatLanguageModel(model)
                    .chatMemory(chatMemory)
                    .build();
    }

}
