package org.example.validators;

import java.util.Set;

public class QuotelyInputValidator implements Validator {

    private static Set<String> expectedInputs = Set.of("English", "Russian");

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
