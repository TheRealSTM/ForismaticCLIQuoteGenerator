# ForismaticCLIQuoteGenerator
ForismaticCLIQuoteGenerator is a Java command line program that fetches quotes from the forismatic.com quote API and displays them to stdout. It supports both English and Russian languages.

## Requirements

To run the ForismaticCLIQuoteGenerator, you will need:

- Java 17 or later
- An internet connection

## Installation

1. Clone the repository:

```
https://github.com/TheRealSTM/ForismaticCLIQuoteGenerator.git
```

2. Build the project:

```
cd QuotelyApp
mvn clean package
```

## Usage

To use ForismaticCLIQuoteGenerator, run the following command:

```
java -jar target/main.jar [language]
```

Replace `[language]` with either `English` or `Russian`.

ForismaticCLIQuoteGenerator will fetch a quote from the forismatic.com quote API and display it to stdout, along with the author of the quote.

Here's an example output from a successful run of the program:
```
Arguments received: [Russian]
Calling the Forismatic API using the language: RUSSIAN
Forismatic returned the quote "Будь у нас больше настойчивости, мы могли бы отыскать путь почти к любой цели. " by Франсуа де Ларошфуко 
Request was satisfied.
```
