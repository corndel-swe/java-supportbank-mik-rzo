package com.corndel.supportbank.exercises;

import java.nio.file.*;
import java.util.List;

public class Adder {
    /**
     * This method reads a file line by line and adds up the numbers on each line.
     * It uses try/catch to print "Something went wrong" and
     * returns 0 in case of an exception.
     *
     * @param fileName The name of the file to be read.
     * @return The sum of the numbers in the file.
     */
    public int add(String fileName) {
        int sum = 0;

        // Read the file
        // Hint: Use Paths.get() and Files.readAllLines()
        Path filepath = Paths.get("src", "data", fileName);
        try {
            List<String> lines = Files.readAllLines(filepath);

            // Add up the numbers
            // Hint: Use a loop
            // Hint: Use Integer.parseInt
            for (String num : lines) {
                sum += Integer.parseInt(num);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return sum;
    }

    /**
     * Calls the add method and prints the result.
     * This method is for debugging purposes only.
     */
    public static void main(String[] args) {
        try {
            Adder adder = new Adder();
            int sum = adder.add("nums.txt");
            System.out.println(sum);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
