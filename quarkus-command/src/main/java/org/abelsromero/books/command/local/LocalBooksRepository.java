package org.abelsromero.books.command.local;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.abelsromero.books.command.local.LocalBook;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LocalBooksRepository {

    @ConfigProperty(name = "quarkus.mongodb.database")
    String database;

    @ConfigProperty(name = "mongodb.collection")
    String collection;

    @Inject
    MongoClient mongoClient;

    public MongoCollection<LocalBook> getCollection() {
        return mongoClient.getDatabase(database).getCollection(collection, LocalBook.class);
    }

    public List<LocalBook> findAll() {
        return getCollection()
            .find()
            .into(new ArrayList<>());
    }

}
