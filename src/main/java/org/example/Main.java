package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.modules.APIModule;
import org.example.modules.ValidatorModule;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ValidatorModule(),
                                                 new APIModule());
        ForismaticCLIQuoteGeneratorApp app = injector.getInstance(ForismaticCLIQuoteGeneratorApp.class);
        app.processRequest(args);
    }
}