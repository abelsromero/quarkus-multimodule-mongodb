package org.abelsromero.books.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@RegisterForReflection
public class Author {

    // TODO: native does not seem to support LocalDate ootb
    String name;
    //    LocalDate birthDay;
    //    Optional<LocalDate> deathDate;
//    Map<String, String> metadata;

}
