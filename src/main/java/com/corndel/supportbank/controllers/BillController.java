package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.BillSplitService;
import picocli.CommandLine.Command;

@Command(name = "bill", subcommands = {BillSplitService.class})
public class BillController {
}
