package com.corndel.supportbank.utils;

import com.corndel.supportbank.models.TransactionModel;

import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {

    public static ArrayList<TransactionModel> CreateTransactionList(List<String> lines) {
        ArrayList<TransactionModel> transactions = new ArrayList<>();
        for (String line : lines.subList(1, lines.size())) {
            String[] arr = line.split(",");
            transactions.add(new TransactionModel(
                    arr[0],
                    arr[1],
                    arr[2],
                    arr[3],
                    Double.parseDouble(arr[4])));
        }
        return transactions;
    }

    public static double AddTransactions(double a, double b) {
        return ((a * 100) + (b * 100)) / 100;
    }

}
