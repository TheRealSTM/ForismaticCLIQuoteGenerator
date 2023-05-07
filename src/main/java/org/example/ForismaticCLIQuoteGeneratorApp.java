package org.example;

import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.example.enums.Language;
import org.example.validators.Validator;

import java.util.Arrays;

@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class ForismaticCLIQuoteGeneratorApp {

    private final Validator validator;

    private final ForismaticAPICaller caller;

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
