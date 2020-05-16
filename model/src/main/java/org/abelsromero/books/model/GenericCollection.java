package org.abelsromero.books.model;

import lombok.Getter;

import java.util.Collection;

@Getter
public class GenericCollection<T> {

    private final Collection<T> values;
    private final long size;

    public GenericCollection(Collection<T> values) {
        this.values = values;
        this.size = values == null ? 0 : values.size();
    }

}
