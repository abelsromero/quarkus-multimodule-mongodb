package org.abelsromero.books.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Book {

    // NOTE: must use ObjectId for automatic mapping and have AllArgs, Getters & Setters
//    String id;
    ObjectId id;
    String title;
    Integer year;
    Genre genre;
//    Optional<String> editor;
//    Optional<String> summary;

//    List<Author> authors;

//    Map<String, String> metadata;
}
