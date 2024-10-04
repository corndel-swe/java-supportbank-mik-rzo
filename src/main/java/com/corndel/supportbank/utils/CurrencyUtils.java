package com.corndel.supportbank.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

public class CurrencyUtils {

    public static String formatTimestamp(Long timestamp) {
        Date date = new Date(timestamp * 1000);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    public static Map<String, Double> exchangeRates(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        var tree = objectMapper.readTree(json);

        // retrieve currency rates from json
        JsonNode ratesNode = tree.get("rates");

        // convert jsonNode to a map
        Map<String, Double> rates = objectMapper.convertValue(ratesNode, Map.class);

        return rates;
    }
}
