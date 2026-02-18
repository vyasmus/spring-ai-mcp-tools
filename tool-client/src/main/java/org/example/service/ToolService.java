package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class ToolService {

    private static final Logger logger = LoggerFactory.getLogger(ToolService.class);


    /*public ToolService(ChatClient chatClient, List<McpSyncClient> mcpSyncClients) {
        this.toolsServer = toolsServer;
    }

    public String getWeasther(){
        return toolsServer..callTool("getWeather");
    }*/

    //@McpLogging(clients = "mcp-server-1")
    /*public void loggingHandler(LoggingMessageNotification loggingMessage) {
        logger.info("MCP LOGGING: [{}] {}", loggingMessage.level(), loggingMessage.data());
    }*/

    //@McpSampling(clients = "mcp-server-1")
    /*public CreateMessageResult weatherHandler(CreateMessageRequest llmRequest) {

        logger.info("MCP SAMPLING: {}", llmRequest);

        String llmResponse = chatClient.prompt()
                .system(llmRequest.systemPrompt())
                .user(((TextContent) llmRequest.messages().get(0).content()).text())
                .call()
                .content();

        return CreateMessageResult.builder().content(new TextContent(llmResponse)).build();
    }*/
}
