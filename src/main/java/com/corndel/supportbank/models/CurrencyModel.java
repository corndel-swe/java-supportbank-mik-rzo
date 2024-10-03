package com.corndel.supportbank.models;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.type.TypeReference;

public class CurrencyModel {
    private final Map<String, Double> exchangeRates;

    public CurrencyModel(String json) throws Exception {
        this.exchangeRates = retrieveExchangeRates(json);
    }

    private Map<String, Double> retrieveExchangeRates(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        var tree = objectMapper.readTree(json);

        // retrieve currency rates from json
        JsonNode ratesNode = tree.get("rates");

        // convert jsonNode to a map
        Map<String, Double> rates = objectMapper.convertValue(ratesNode, new TypeReference<Map<String, Double>>() {});

        return rates;
    }

    public Map<String, Double> getExchangeRates() {
        return this.exchangeRates;
    }
}
