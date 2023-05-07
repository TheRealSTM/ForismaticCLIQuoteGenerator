package org.example.validators;

/**
 * The Validator interface provides a method for validating a given set of arguments.
 */
public interface Validator {

        /**
         * Validates the given arguments.
         *
         * @param args an array of strings representing the arguments to validate
         * @return true if the arguments are valid, false otherwise
         */
        public boolean validate(String[] args);
}