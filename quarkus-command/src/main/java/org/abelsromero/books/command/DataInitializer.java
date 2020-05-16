package org.abelsromero.books.command;

import org.abelsromero.books.model.Book;
import org.abelsromero.books.tools.RandomBookGenerator;

import java.util.ArrayList;

public class DataInitializer {

    private final RandomBookGenerator bookGenerator = new RandomBookGenerator();

    private final BooksRepository booksRepository;

    public DataInitializer(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public void initDataWithArray(int size) {
        final Book[] books = new Book[size];
        for (int i = 0; i < size; i++) {
            books[i] = bookGenerator.generateBook();
        }
        booksRepository.clear();
        booksRepository.add(books);
    }

    public void initDataWithList(int size) {
        final var books = new ArrayList<Book>();
        for (int i = 0; i < size; i++) {
            books.add(bookGenerator.generateBook());
        }
        booksRepository.clear();
        booksRepository.add(books);
    }
}
