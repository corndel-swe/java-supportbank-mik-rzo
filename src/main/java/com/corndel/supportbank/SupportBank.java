package com.corndel.supportbank;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import com.corndel.supportbank.controllers.BillController;
import com.corndel.supportbank.controllers.TransactionController;

@Command(name = "supportbank", subcommands = {BillController.class, TransactionController.class})
public class SupportBank {

    public static void main(String[] args) {
        CommandLine cli = new CommandLine(new SupportBank());
        int exitCode = cli.execute(args);
        System.exit(exitCode);
    }
}
