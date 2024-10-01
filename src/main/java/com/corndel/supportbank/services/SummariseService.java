package com.corndel.supportbank.services;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import com.corndel.supportbank.models.TransactionModel;
import com.corndel.supportbank.utils.FileIO;
import com.corndel.supportbank.utils.TransactionUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@Command(name = "summarise")
public class SummariseService implements Runnable {

    @Parameters(index = "0")
    private String fileName;

    @Override
    public void run() {
        try {
            // read transactions file
            FileIO inputFile = new FileIO(fileName);
            List<String> lines = inputFile.readLines();

            // create iterable list of transactions
            ArrayList<TransactionModel> transactions = TransactionUtils.CreateTransactionList(lines);

            // use hashmap to keep track of accounts
            Map<String, Double> accounts = new HashMap<>();
            for (TransactionModel transaction : transactions) {

                // decrement balance for account with outgoing transfer
                double oldBalance = accounts.getOrDefault(transaction.getFromAccount(), 0.0);
                double newBalance = TransactionUtils.AddTransactions(oldBalance, transaction.getAmount() * -1);
                accounts.put(transaction.getFromAccount(), newBalance);

                // increment balance for account with incoming transfer
                oldBalance = accounts.getOrDefault(transaction.getToAccount(), 0.0);
                newBalance = TransactionUtils.AddTransactions(oldBalance, transaction.getAmount());
                accounts.put(transaction.getToAccount(), newBalance);
            }

            accounts.forEach((accountName, balance) -> {
                System.out.printf("%s : %.2f%n", accountName, balance);
            });

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
