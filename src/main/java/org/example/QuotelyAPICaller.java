package org.example;

import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.example.enums.Language;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class QuotelyAPICaller {

    private static final String FORISMATIC_API_ENDPOINT = "http://api.forismatic.com/api/1.0/";

    final HttpClient httpClient;

    public void callForismatic(Language language) {
        System.out.println("Calling the Forismatic API using the language: " + language);

        var request = HttpRequest.newBuilder(URI.create(FORISMATIC_API_ENDPOINT))
                .header("accept", "application/json")
                .GET()
                .build();
        String jsonResponse;
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            jsonResponse = response.toString();
        } catch (IOException | InterruptedException e) {
            System.out.println("The API call to forismatic failed with the following error: " + e);
            return;
        }

        System.out.println("Forismatic returned the following string: " + jsonResponse);
    }
}
