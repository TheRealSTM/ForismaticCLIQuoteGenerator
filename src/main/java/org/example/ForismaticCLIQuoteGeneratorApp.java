package org.example;

import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.example.enums.Language;
import org.example.validators.Validator;

import java.util.Arrays;

/**
  * ForismaticCLIQuoteGeneratorApp is responsible for handling the command line inputs
  * passed to the application, validating them, and calling the Forismatic API to get
  * a quote in the specified language.
  */
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class ForismaticCLIQuoteGeneratorApp {

    private final Validator validator;

    private final ForismaticAPICaller caller;

    /**
      * Processes the request received from the command line arguments, validates them using the validator,
      * and calls the Forismatic API through the caller object to retrieve the quote. If the request is
      * invalid, an error message is printed and the method returns.
      * @param args The command line arguments passed to the application.
      */
    public void processRequest(String[] args) {
        System.out.println("Arguments received: " + Arrays.toString(args));
        if (!validator.validate(args)) {
            System.out.println("Request is invalid");
            return;
        }
        Language language = Language.getLanguage(args[0]);
        caller.callForismatic(language);
        System.out.println("Request was satisfied.");
    }
}
