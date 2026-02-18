package org.example.service;

import io.modelcontextprotocol.server.McpSyncServerExchange;
import jdk.jfr.Description;
import org.example.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
    private final RestClient restClient = RestClient.create();

    @McpTool(description="Get the temperature (in celsius) for a specific location")
    public String getWeather(McpSyncServerExchange exchange,
                             @McpToolParam(description = "The location latitude") double latitude,
                             @McpToolParam(description = "The location longitude") double longitude) {

        log.info("getWeather");

        WeatherResponse weatherResponse = restClient.get()
                .uri("https://api.open-meteo.com/v1/forecast?latitude={latitude}&longitude={longitude}&current=temperature_2m&temperature_unit=fahrenheit",
                        latitude, longitude)
                .retrieve()
                .body(WeatherResponse.class);

        return "Temperature " + String.valueOf(weatherResponse.getCurrent().getTemperature_2m()) + " " + String.valueOf(weatherResponse.getCurrent_units().getTemperature_2m());
    }
}
