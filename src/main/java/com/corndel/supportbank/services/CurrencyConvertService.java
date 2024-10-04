package com.corndel.supportbank.services;

import com.corndel.supportbank.models.CurrencyModel;
import com.corndel.supportbank.utils.OpenExchangeRateAPI;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "convert")
public class CurrencyConvertService implements Runnable {

    @Parameters(index = "0")
    private Double amount;

    @Parameters(index = "1")
    private String convertFrom;

    @Parameters(index = "2")
    private String convertTo;

    @Override
    public void run() {
        // make api request
        OpenExchangeRateAPI api = new OpenExchangeRateAPI("latest.json");
        String json = api.getRequest();

        try {
            // retrieve exchange rates from string json
            CurrencyModel currency = new CurrencyModel(json);

            // invoke conversion
            Double convertedAmount = currency.conversion(amount, convertFrom, convertTo);
            System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, convertFrom, convertedAmount, convertTo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
