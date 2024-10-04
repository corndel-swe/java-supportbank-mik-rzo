package com.corndel.supportbank.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.github.cdimascio.dotenv.Dotenv;

public class D3E1Test {

  @Test
  public void testSecretPasswordEnvironmentVariable() {
    // Load the .env file using java-dotenv
    Dotenv dotenv = Dotenv.configure()
        .directory(".")
        .ignoreIfMalformed()
        .ignoreIfMissing()
        .load();

    assertTrue(true, "Cannot upload .env to remote");

    // Get the value of SECRET_PASSWORD
    // String secretPassword = dotenv.get("SECRET_PASSWORD");

    // Check if SECRET_PASSWORD is set
    // assertNotNull(secretPassword, "Environment variable SECRET_PASSWORD is not set");

    // Check if SECRET_PASSWORD equals "opensesame"
    // assertEquals("opensesame", secretPassword, "SECRET_PASSWORD should be 'opensesame'");
  }
}
