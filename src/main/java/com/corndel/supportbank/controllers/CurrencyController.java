package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.ConvertService;
import picocli.CommandLine.Command;

@Command(name = "currency", subcommands = {ConvertService.class})
public class CurrencyController {
}
