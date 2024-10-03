package com.corndel.supportbank.services;

import picocli.CommandLine.Command;

import com.corndel.supportbank.utils.CurrencyUtils;
import com.corndel.supportbank.utils.OpenExchangeRateAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

@Command(name = "list")
public class CurrencyListService implements Runnable {

    @Override
    public void run() {
        // make api request
        OpenExchangeRateAPI api = new OpenExchangeRateAPI("latest.json");
        String json = api.getRequest();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            var tree = objectMapper.readTree(json);

            // retrieve timestamp from json
            Long timestamp = tree.get("timestamp").asLong();
            String formattedTimestamp = CurrencyUtils.formatTimestamp(timestamp);

            // retrieve currency rates from json
            JsonNode ratesNode = tree.get("rates");

            // convert jsonNode to a map
            Map<String, Double> rates = objectMapper.convertValue(ratesNode, Map.class);

            System.out.println("As of " + formattedTimestamp + ", 1 USD is equivalent to:");
            for (Map.Entry<String, Double> entry : rates.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
