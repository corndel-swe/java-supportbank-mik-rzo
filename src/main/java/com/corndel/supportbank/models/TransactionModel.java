package com.corndel.supportbank.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TransactionModel {
    private final LocalDate date;
    private final String fromAccount;
    private final String toAccount;
    private final String narrative;
    private final double amount;

    public TransactionModel(String date, String fromAccount, String toAccount, String narrative, double amount) {
        this.date = formatDate(date);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.narrative = narrative;
        this.amount = amount;
    }

    private LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format: " + e.getMessage());
        }

        return null;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getFromAccount() {
        return this.fromAccount;
    }

    public String getToAccount() {
        return this.toAccount;
    }

    public String getNarrative() {
        return this.narrative;
    }

    public double getAmount() {
        return this.amount;
    }
}
