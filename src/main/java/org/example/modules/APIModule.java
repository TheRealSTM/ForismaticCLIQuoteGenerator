package org.example.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.example.ForismaticAPICaller;

import java.net.http.HttpClient;

public class APIModule extends AbstractModule {
    @Provides
    static ForismaticAPICaller provideQuotelyAPICaller(HttpClient httpClient) {
        return new ForismaticAPICaller(httpClient);
    }

    @Provides
    static HttpClient providesHTTPClient() {
        return HttpClient.newHttpClient();
    }
}