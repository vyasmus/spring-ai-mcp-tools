package org.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ToolsController {

    private static final Logger log = LoggerFactory.getLogger(ToolsController.class);

    @Autowired
    private ChatClient chatClient;

    @PostMapping(path = "/message")
    public String sendMessage(@RequestBody String message){

       log.info("Input Chat message: " + message);

       return chatClient.prompt().user(message).call().content();
    }
}
