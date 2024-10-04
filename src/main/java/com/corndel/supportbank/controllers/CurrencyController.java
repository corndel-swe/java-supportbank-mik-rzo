package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.CurrencyConvertService;
import com.corndel.supportbank.services.CurrencyListService;
import picocli.CommandLine.Command;

@Command(name = "currency", subcommands = {CurrencyConvertService.class, CurrencyListService.class})
public class CurrencyController {
}
