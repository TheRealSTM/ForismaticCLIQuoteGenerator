package org.example.enums;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * The Language enumeration represents the available languages for the quotely command line program.
 * Each language has a name and an abbreviation, and can be retrieved by its name using the {@link #getLanguage(String)} method.
 */
@RequiredArgsConstructor
@Getter
public enum Language {
    ENGLISH("English", "en"),
    RUSSIAN("Russian", "ru");

    private final String languageName;
    private final String languageAbbreviation;
    private static Map<String, Language> languageNameToLanguageMapping = Maps.newHashMap();

    static {
        for (Language language : Language.values()) {
            languageNameToLanguageMapping.put(language.getLanguageName(), language);
        }
    }

    /**
     * Returns the Language enum value corresponding to the given language name.
     * Throws an IllegalArgumentException if the language name is not recognized.
     *
     * @param languageName the name of the language to retrieve
     * @return the Language enum value corresponding to the given language name
     * @throws IllegalArgumentException if the language name is not recognized
     */
    public static Language getLanguage(String languageName) {
        if (languageNameToLanguageMapping.get(languageName) == null) {
            throw new IllegalArgumentException("The provided languageName (" + languageName + ") is not recognized.");
        }
        return languageNameToLanguageMapping.get(languageName);
    }
}
