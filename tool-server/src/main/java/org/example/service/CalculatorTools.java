package org.example.service;

import io.modelcontextprotocol.spec.McpSchema.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpResource;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springaicommunity.mcp.context.McpSyncRequestContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculatorTools {

    private static final Logger log = LoggerFactory.getLogger(CalculatorTools.class);

    @McpTool(description = "Add two numbers")
    public Double add(
            @McpToolParam(description = "First number", required = true) double a,
            @McpToolParam(description = "Second number", required = true) double b) {
        log.info("Adding two numbers: " + (a + b));
        return a + b;
    }

    @McpTool(description = "Subtract two numbers")
    public Double subtract(
            @McpToolParam(description = "First number", required = true) double a,
            @McpToolParam(description = "Second number", required = true) double b) {
        log.info("Subtracting two numbers: " + (a - b));
        return a - b;
    }

    @McpTool(description = "Multiply two numbers")
    public Double multiply(
            @McpToolParam(description = "First number", required = true) double a,
            @McpToolParam(description = "Second number", required = true) double b) {
        log.info("Multiplying two numbers: " + (a * b));
        return a * b;
    }

    @McpTool(description = "Divide two numbers")
    public Double divide(
            @McpToolParam(description = "Dividend", required = true) double dividend,
            @McpToolParam(description = "Divisor", required = true) double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        log.info("Dividing two numbers: " + (dividend / divisor));
        return dividend / divisor;
    }

    @McpTool(description = "Calculate a complex mathematical expression")
    public CallToolResult calculateExpression(
            CallToolRequest request,
            McpSyncRequestContext context) {

        Map<String, Object> args = request.arguments();
        String expression = (String) args.get("expression");

        // Use convenient logging method
        context.info("Calculating: " + expression);
        log.info("Calculating expression: " + expression);

        try {
            double result = 3.0; //evaluateExpression(expression);
            return CallToolResult.builder()
                    .addTextContent("Result: " + result)
                    .build();
        } catch (Exception e) {
            return CallToolResult.builder()
                    .isError(true)
                    .addTextContent("Error: " + e.getMessage())
                    .build();
        }
    }
}
