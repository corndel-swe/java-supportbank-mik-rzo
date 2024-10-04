package com.corndel.supportbank.services;

import picocli.CommandLine.Command;

import com.corndel.supportbank.utils.OpenExchangeRateAPI;
import com.corndel.supportbank.models.CurrencyModel;

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
            CurrencyModel currency = new CurrencyModel(json);
            Map<String, Double> exchangeRates = currency.getExchangeRates();

            System.out.println("1 USD is equivalent to: ");
            for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
