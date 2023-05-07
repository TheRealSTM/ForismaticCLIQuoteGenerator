package org.example.validators;

import java.util.Set;

/**
 * Validates input for the Quotely program.
 */
public class QuotelyInputValidator implements Validator {

    /**
     * Set of expected inputs.
     */
    private static Set<String> expectedInputs = Set.of("English", "Russian");

    /**
     * Validates input for the Quotely program.
     *
     * @param args the arguments to validate
     * @return true if the input is valid, false otherwise
     */
    public boolean validate(String[] args) {
        if (args.length != 1) {
            System.out.println("The expected number of inputs is 1. The provided size is " + args.length);
            return false;
        }
        String input = args[0];
        if (!expectedInputs.contains(input)) {
            System.out.println("The expected inputs are " + expectedInputs + ". The provided input is " + input);
            return false;
        }
        return true;
    }
}
