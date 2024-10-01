package com.corndel.supportbank.services;

import com.corndel.supportbank.models.CurrencyModel;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name="convert")
public class ConvertService implements Runnable {

    @Parameters(index="0")
    private int amount;

    @Parameters(index="1")
    private String convertFrom;

    @Parameters(index="2")
    private String convertTo;

    @Override
    public void run() {
        CurrencyModel currency = new CurrencyModel(amount, convertFrom, convertTo);
        System.out.printf("%.2f %s -> %.2f %s",
                currency.getAmountBeforeConversion(),
                currency.getConvertFrom(),
                currency.getAmountAfterConversion(),
                currency.getConvertTo());
    }
}
