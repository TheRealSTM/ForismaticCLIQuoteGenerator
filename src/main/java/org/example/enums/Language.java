package org.example.enums;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum Language {
    ENGLISH("English", "en"),
    RUSSIAN("RUSSIAN", "ru");

    private final String languageName;
    private final String languageAbbreviation;
    public static Map<String, Language> languageNameToLanguageMapping = Maps.newHashMap();

    static {
        for (Language language : Language.values()) {
            languageNameToLanguageMapping.put(language.getLanguageName(), language);
        }
    }

    public static Language getLanguage(String languageName) {
        if (languageNameToLanguageMapping.get(languageName) == null) {
            throw new IllegalArgumentException("The provided languageName (" + languageName + ") is not recognized.");
        }
        return languageNameToLanguageMapping.get(languageName);
    }
}
