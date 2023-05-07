package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * This class represents a quote and relevant metadata obtained from the forismatic.com quote API.
 */
@AllArgsConstructor
@Builder
@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private final String quoteText;
    private final String quoteAuthor;
    private final String quoteLink;
}
