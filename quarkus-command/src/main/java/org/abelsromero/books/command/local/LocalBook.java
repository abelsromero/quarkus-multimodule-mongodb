package org.abelsromero.books.command.local;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.abelsromero.books.model.Genre;
import org.bson.types.ObjectId;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class LocalBook {

    ObjectId id;
    String title;
    Integer year;
    Genre genre;

}
