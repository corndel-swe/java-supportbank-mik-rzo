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

        try {
            // retrieve exchange rates from string json
            Map<String, Double> rates = CurrencyUtils.exchangeRates(json);
            System.out.println("1 USD is equivalent to:");
            for (Map.Entry<String, Double> entry : rates.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
