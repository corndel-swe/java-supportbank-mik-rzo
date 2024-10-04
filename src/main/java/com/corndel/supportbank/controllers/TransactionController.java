package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.TransactionListService;
import com.corndel.supportbank.services.TransactionSummariseService;

import picocli.CommandLine.Command;

@Command(name = "transaction", subcommands = {TransactionSummariseService.class, TransactionListService.class})
public class TransactionController {
}
