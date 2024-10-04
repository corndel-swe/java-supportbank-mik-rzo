package com.corndel.supportbank.exercises;

import kong.unirest.Unirest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class represents a Pokemon. It uses Java's record syntax to
 * automatically generate a class with getters and utility methods.
 * See this url for more info:
 * https://www.baeldung.com/java-record-keyword
 */
@JsonIgnoreProperties(ignoreUnknown = true)
record Pokemon(Integer id, String name, Integer height, Integer weight) {
}

public class PokeAPI {
    /**
     * Get a Pokemon by its name.
     * <p>
     * Makes a GET request to the PokeAPI, and uses Jackson to parse the JSON
     * response into a Pokemon object.
     *
     * @param name The name of the Pokemon to retrieve.
     * @return The Pokemon object.
     */
    public static Pokemon getPokemonByName(String name) throws Exception {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;

        // Make a GET request to the url
        // Hint: Use Unirest.get()
        var response = Unirest.get(url).header("Accept", "application/json").asString();
        String json = response.getBody();

        // Parse the response body into a Pokemon object
        // Hint: Use Jackson's ObjectMapper to map the response body to Pokemon.class
        ObjectMapper objectMapper = new ObjectMapper();
        Pokemon pokemon = objectMapper.readValue(json, Pokemon.class);

        return pokemon;
    }

    /**
     * For debugging purposes..
     */
    public static void main(String[] args) {
        try {
            Pokemon pokemon = getPokemonByName("pikachu");
            System.out.println(pokemon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
