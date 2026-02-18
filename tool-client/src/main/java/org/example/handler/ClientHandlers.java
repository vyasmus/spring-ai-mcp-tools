package org.example.handler;

import io.modelcontextprotocol.spec.McpSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class ClientHandlers {

    private final Logger logger = LoggerFactory.getLogger(ClientHandlers.class);
    //private final ProgressTracker progressTracker = new ProgressTracker();
    /*private final ChatModel chatModel;

    public ClientHandlers(@Lazy ChatModel chatModel) {
        this.chatModel = chatModel;
    }*/

    //@McpLogging(clients = "mcp-server-1")
    public void handleLogging(McpSchema.LoggingMessageNotification notification) {
        switch (notification.level()) {
            case ERROR:
                logger.error("[MCP] {} - {}", notification.logger(), notification.data());
                break;
            case WARNING:
                logger.warn("[MCP] {} - {}", notification.logger(), notification.data());
                break;
            case INFO:
                logger.info("[MCP] {} - {}", notification.logger(), notification.data());
                break;
            default:
                logger.debug("[MCP] {} - {}", notification.logger(), notification.data());
        }
    }

    //@McpSampling(clients = "mcp-server-1")
    /*public McpSchema.CreateMessageResult handleSampling(McpSchema.CreateMessageRequest request) {
        // Use Spring AI ChatModel for sampling
        List<Message> messages = request.messages().stream()
                .map(msg -> {
                    if (msg.role() == McpSchema.Role.USER) {
                        return new UserMessage(((McpSchema.TextContent) msg.content()).text());
                    } else {
                        return AssistantMessage.builder()
                                .content(((McpSchema.TextContent) msg.content()).text())
                                .build();
                    }
                })
                .map( message -> (Message) message)
                .toList();

        ChatResponse response = chatModel.call( new Prompt(messages) );

        return McpSchema.CreateMessageResult.builder()
                .role(McpSchema.Role.ASSISTANT)
                .content(new McpSchema.TextContent(response.getResult().getOutput().getText()))
                .model(request.modelPreferences().hints().get(0).name())
                .build();
    }*/

    //@McpElicitation(clients = "mcp-server-1")
    public McpSchema.ElicitResult handleElicitation(McpSchema.ElicitRequest request) {
        // In a real application, this would show a UI dialog
        Map<String, Object> userData = new HashMap<>();

        logger.info("Elicitation requested: {}", request.message());

        // Simulate user input based on schema
        /*Map<String, Object> schema = request.requestedSchema();
        if (schema != null && schema.containsKey("properties")) {
            Map<String, Object> properties = (Map<String, Object>) schema.get("properties");

            properties.forEach((key, value) -> {
                // In real app, prompt user for each field
                userData.put(key, getDefaultValueForProperty(key, value));
            });
        }*/

        return new McpSchema.ElicitResult(McpSchema.ElicitResult.Action.ACCEPT, userData);
    }

    //@McpProgress(clients = "mcp-server-1")
    public void handleProgress(McpSchema.ProgressNotification notification) {
        /*progressTracker.update(
                notification.progressToken(),
                notification.progress(),
                notification.total(),
                notification.message()
        );*/

        // Update UI or send websocket notification
        //broadcastProgress(notification);
    }

    //@McpToolListChanged(clients = "mcp-server-1")
    public void handleServer1ToolsChanged(List<McpSchema.Tool> tools) {
        logger.info("Server1 tools updated: {} tools available", tools.size());

        // Update tool registry
        //toolRegistry.updateServerTools("server1", tools);

        // Notify UI to refresh tool list
        //eventBus.publish(new ToolsUpdatedEvent("server1", tools));
    }

    //@McpResourceListChanged(clients = "mcp-server-1")
    public void handleServer1ResourcesChanged(List<McpSchema.Resource> resources) {
        logger.info("Server1 resources updated: {} resources available", resources.size());

        // Clear resource cache for this server
        //resourceCache.clearServer("server1");

        // Register new resources
        /*resources.forEach(resource ->
                resourceCache.register("server1", resource));*/
    }
}
