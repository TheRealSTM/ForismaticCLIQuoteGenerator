package org.example.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class LanguageTest {
    @Test
    @DisplayName("Test that getLanguage returns the correct Language for a given languageName")
    void testGetLanguage() {
        assertEquals(Language.ENGLISH, Language.getLanguage("English"));
        assertEquals(Language.RUSSIAN, Language.getLanguage("Russian"));
    }

    @Test
    @DisplayName("Test that getLanguage throws an exception for an unrecognized languageName")
    void testGetLanguageThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Language.getLanguage("Spanish"));
    }
}