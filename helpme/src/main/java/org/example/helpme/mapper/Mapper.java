package org.example.helpme.mapper;

public interface Mapper <A, B> {
    B /*dto*/toDto(A/*Entity*/ a);
    A toEntity(B b);
}
