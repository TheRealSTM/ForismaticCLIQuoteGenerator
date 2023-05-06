package org.example.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.example.QuotelyAPICaller;

import java.net.http.HttpClient;

public class APIModule extends AbstractModule {
    @Provides
    static QuotelyAPICaller provideQuotelyAPICaller(HttpClient httpClient) {
        return new QuotelyAPICaller(httpClient);
    }

    @Provides
    static HttpClient providesHTTPClient() {
        return HttpClient.newHttpClient();
    }
}