package org.example.modules;

import com.google.inject.AbstractModule;
import org.example.validators.QuotelyInputValidator;
import org.example.validators.Validator;

public class ValidatorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Validator.class).to(QuotelyInputValidator.class);
    }
}
