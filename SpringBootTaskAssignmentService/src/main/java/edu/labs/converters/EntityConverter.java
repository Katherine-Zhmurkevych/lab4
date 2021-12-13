package edu.labs.converters;

public interface EntityConverter<T, E> {
    T toEntity(E dto);

    E toDto(T item);
}
