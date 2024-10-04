package com.corndel.supportbank.utils;

import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

public class OpenExchangeRateAPI {
    private String url;

    public OpenExchangeRateAPI(String endpoint) {
        this.url = createURL(endpoint);
    }

    private String createURL(String endpoint) {
        // retrieve OPEN_EXCHANGE_RATES_APP_ID environment variable
        Dotenv dotenv = Dotenv.load();
        String appID = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");

        // create url string with additional query parameters
        return "https://openexchangerates.org/api/" + endpoint + "?app_id=" + appID +
                "&prettyprint=true";

    }

    // returns response body as JSON string
    public String getRequest() {
        var response = Unirest.get(this.url).header("Accept", "application/json").asString();
        return response.getBody();
    }
}
