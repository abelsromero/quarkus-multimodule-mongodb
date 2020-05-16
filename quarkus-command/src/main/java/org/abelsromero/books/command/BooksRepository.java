package org.abelsromero.books.command;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.abelsromero.books.model.Book;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class BooksRepository {

    @ConfigProperty(name = "quarkus.mongodb.database")
    String database;

    @ConfigProperty(name = "mongodb.collection")
    String collection;

    @Inject
    MongoClient mongoClient;

    public MongoCollection<Book> getCollection() {
        return mongoClient.getDatabase(database).getCollection(collection, Book.class);
    }

    public void add(Book... books) {
        add(Arrays.asList(books));
    }

    public void add(List<Book> books) {
        getCollection()
            .insertMany(books);
    }

    public List<Book> findAll() {
        return getCollection()
            .find()
            .into(new ArrayList<>());
    }

    public void clear() {
        getCollection().deleteMany(new Document());
    }
}
