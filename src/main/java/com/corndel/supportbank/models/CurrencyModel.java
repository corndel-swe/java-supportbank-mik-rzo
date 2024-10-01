package com.corndel.supportbank.models;

public class CurrencyModel {
    private final double amountBeforeConversion;
    private final String convertFrom;
    private final double amountAfterConversion;
    private final String convertTo;

    public CurrencyModel(int amountBeforeConversion, String convertFrom, String convertTo) {
        this.amountBeforeConversion = amountBeforeConversion;
        this.convertFrom = convertFrom;
        this.amountAfterConversion = conversion(amountBeforeConversion);
        this.convertTo = convertTo;
    }

    public double getAmountBeforeConversion() {
        return this.amountBeforeConversion;
    }

    public String getConvertFrom() {
        return this.convertFrom;
    }

    public double getAmountAfterConversion() {
        return this.amountAfterConversion;
    }

    public String getConvertTo() {
        return this.convertTo;
    }

    private double conversion(double amountBeforeConversion) {
        return (amountBeforeConversion * 100 * 753) / 100000;
    }
}
