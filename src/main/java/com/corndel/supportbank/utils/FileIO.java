package com.corndel.supportbank.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIO {
    private final Path filePath;

    public FileIO(String fileName) {
        this.filePath = Paths.get("src", "data", "transactions", fileName);
    }

    public List<String> readLines() throws IOException {
        return Files.readAllLines(this.filePath);
    }
}
