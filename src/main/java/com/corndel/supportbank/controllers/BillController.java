package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.SplitService;
import picocli.CommandLine.Command;

@Command(name = "bill", subcommands = {SplitService.class})
public class BillController {
}
