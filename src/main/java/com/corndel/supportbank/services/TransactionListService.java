package com.corndel.supportbank.services;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import com.corndel.supportbank.models.TransactionModel;
import com.corndel.supportbank.utils.FileIO;
import com.corndel.supportbank.utils.TransactionUtils;

import java.util.List;
import java.util.ArrayList;

@Command(name = "list")
public class TransactionListService implements Runnable {

    @Parameters(index = "0")
    private String fileName;

    @Parameters(index = "1")
    private String accountName;

    @Override
    public void run() {
        try {
            // read transactions file
            FileIO inputFile = new FileIO(fileName);
            List<String> lines = inputFile.readLines();

            // create iterable list of transactions
            ArrayList<TransactionModel> transactions = TransactionUtils.CreateTransactionList(lines);

            for (TransactionModel transaction : transactions) {
                // check if transaction involves account holder
                if (transaction.getFromAccount().equalsIgnoreCase(accountName) ||
                        transaction.getToAccount().equalsIgnoreCase(accountName)) {
                    System.out.printf("%s | %s to %s | %s | %.2f%n",
                            transaction.getDate(),
                            transaction.getFromAccount(),
                            transaction.getToAccount(),
                            transaction.getNarrative(),
                            transaction.getAmount());
                }

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
