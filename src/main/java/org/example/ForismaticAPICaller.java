package org.example;

import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.example.enums.Language;
import org.example.models.Quote;
import org.example.utilities.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class ForismaticAPICaller {

    private static final String FORISMATIC_API_ENDPOINT = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=";

    final HttpClient httpClient;

    public void callForismatic(Language language) {
        System.out.println("Calling the Forismatic API using the language: " + language);

        var request = HttpRequest.newBuilder(URI.create(FORISMATIC_API_ENDPOINT + language.getLanguageAbbreviation()))
                .header("accept", "application/json")
                .GET()
                .build();
        HttpResponse<Supplier<Quote>> response;
        try {
            response = httpClient.send(request, new JsonBodyHandler<>(Quote.class));
        } catch (IOException | InterruptedException e) {
            System.out.println("The API call to forismatic failed with the following error: " + e);
            return;
        }
        Quote quote = response.body().get();
        System.out.println("Forismatic returned the quote \"" + quote.getQuoteText() + "\" by " + quote.getQuoteAuthor());
    }
}
