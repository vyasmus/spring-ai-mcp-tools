package org.example.configuration;


import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToolConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder,
                                 SyncMcpToolCallbackProvider mcpToolProvider) {
        // .defaultToolCallbacks() ensures all tools from your MCP servers
        // are available for every prompt by default.
        return builder
                .defaultToolCallbacks(mcpToolProvider.getToolCallbacks())
                .build();
    }

}
