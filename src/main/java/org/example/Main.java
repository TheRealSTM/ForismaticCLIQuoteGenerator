package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.modules.APIModule;
import org.example.modules.ValidatorModule;

/**
 * This class contains the main method that runs the Forismatic CLI Quote Generator application.
 * The application generates a random quote based on the language specified in the arguments and prints it
 * to the console. If the input is invalid or the API call fails, an error message is printed instead.
 */
public class Main {

    /**
     * The main method that runs the Forismatic CLI Quote Generator application.
     * It creates an instance of the {@link ForismaticCLIQuoteGeneratorApp} class using the Guice dependency
     * injection framework and processes the command-line arguments passed to the application.
     *
     * @param args the command-line arguments passed to the application
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ValidatorModule(),
                new APIModule());
        ForismaticCLIQuoteGeneratorApp app = injector.getInstance(ForismaticCLIQuoteGeneratorApp.class);
        app.processRequest(args);
    }
}