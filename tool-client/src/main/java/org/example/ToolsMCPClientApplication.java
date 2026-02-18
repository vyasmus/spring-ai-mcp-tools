package org.example;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ToolsMCPClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolsMCPClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner predefinedQuestions(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools,
                                                 ConfigurableApplicationContext context) {

        return args -> {

            String userInput = "What is meaning of Hello?";
            var chatClient = chatClientBuilder
                    .defaultToolCallbacks(tools)
                    .build();

            System.out.println("\n>>> QUESTION: " + userInput);
            System.out.println("\n>>> Tools Size: " + Arrays.stream(tools.getToolCallbacks()).count());

            Arrays.stream(tools.getToolCallbacks()).toList()
                    .forEach(callback -> System.out.println( "Callback " + callback.getToolDefinition().name()));
            System.out.println("\n>>> ASSISTANT: " + chatClient.prompt(userInput).call().content());

            //context.close();
        };
    }
}

