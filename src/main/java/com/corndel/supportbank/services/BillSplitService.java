package com.corndel.supportbank.services;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import com.corndel.supportbank.models.BillModel;

@Command(name = "split")
public class BillSplitService implements Runnable {

    @Parameters(index = "0")
    private double total;

    @Parameters(index = "1")
    private int numPeople;

    @Override
    public void run() {
        BillModel bill = new BillModel(total);
        String output = String.format("%.2f", bill.split(numPeople));
        System.out.println("The bill is " + output + " each.");
    }
}
