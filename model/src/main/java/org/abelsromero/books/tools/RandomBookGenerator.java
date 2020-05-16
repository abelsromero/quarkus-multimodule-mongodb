package org.abelsromero.books.tools;

import org.abelsromero.books.model.Author;
import org.abelsromero.books.model.Book;
import org.abelsromero.books.model.Genre;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBookGenerator {

    private final Random random = new Random();

    public Collection<Book> generateBooks(int amount) {
        return amount == 0
            ? List.of()
            : IntStream.range(1, amount + 1)
            .mapToObj(value -> createInstance(value))
            .collect(Collectors.toList());
    }

    public Book generateBook() {
        return createInstance(0);
    }

    private Book createInstance(int index) {
        final String randomKey = randomMetadataKey().replaceAll("-", "");

        return Book.builder()
            .title(new StringBuilder().append("Title (").append(randomKey).append(") ").append(index).toString())
            .year(1900 + random.nextInt(50))
            .genre(randomGenre())
//            .authors(createAuthors(randomInt(3, 10)))
//            .metadata(randomMetadata())
            .build();
    }

    private Genre randomGenre() {
        switch (random.nextInt(4)) {
            case 0:
                return Genre.FANTASY;
            case 1:
                return Genre.SCI_FI;
            case 2:
                return Genre.DRAMA;
            default:
                return Genre.HUMOR;
        }
    }

    private Map<String, String> randomMetadata() {
        int metadataAmount = randomInt(10, 20);

        final Map<String, String> metadata = new HashMap<>();
        for (int i = 0; i < metadataAmount; i++) {
            metadata.put(randomMetadataKey(), randomMetadataValue());
        }
        return metadata;
    }

    private String randomMetadataValue() {
        final String key = UUID.randomUUID().toString();
        return repeat(key, randomInt(3, 25));
    }

    private String repeat(String key, int times) {
        final StringBuilder sb = new StringBuilder();
        sb.append(times + " |");
        for (int i = 0; i < times; i++) {
            sb.append(key + " |");
        }
        return sb.toString();
    }

    private String randomMetadataKey() {
        final String key = UUID.randomUUID().toString();
        return key.substring(0, key.indexOf('-'));
    }

    private List<Author> createAuthors(int amount) {
        return (amount == 0)
            ? List.of()
            : IntStream.range(1, amount + 1)
            .mapToObj(value -> createAuthor())
            .collect(Collectors.toList());
    }

    private Author createAuthor() {
        final String randomKey = UUID.randomUUID().toString().replaceAll("-", "");

        return Author.builder()
            .name(randomKey)
//            .birthDay(randomDate())
//            .deathDate(Optional.of(randomDate()))
            .build();
    }

    private LocalDate randomDate() {
        int month = randomInt(1, 12);
        return LocalDate.of(randomInt(1920, 2020), month, randomInt(1, month == 2 ? 28 : 30));
    }

    private int randomInt(int lowerBound, int upperBound) {
        return lowerBound + random.nextInt(upperBound - lowerBound);
    }

}
