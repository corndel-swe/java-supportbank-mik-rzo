package com.corndel.supportbank.models;

public class BillModel {
    private double total;

    public BillModel(double total) {
        this.total = total;
    }

    public double split(int numPeople) {
        return this.total / numPeople;
    }
}
