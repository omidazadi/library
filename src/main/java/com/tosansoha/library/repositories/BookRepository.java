package com.tosansoha.library.repositories;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tosansoha.library.models.*;

public interface BookRepository extends JpaRepository <Book, Integer> {
    public static Book updateChanges(Book book, Map<String, String> changes) {
        if (changes.containsKey("title")){
            book.setTitle(changes.get("title"));
        }
        if (changes.containsKey("author")){
            book.setAuthor(changes.get("author"));
        }
        if (changes.containsKey("price")){
            book.setPrice(Float.parseFloat(changes.get("price")));
        }
        if (changes.containsKey("publicationDate")){
            book.setPublicationDate(LocalDate.parse(changes.get("publicationDate")));
        }
        if (changes.containsKey("description")){
            book.setDescription(changes.get("description"));
        }
        return book;
    }

    public static Book mapToModel(Map<String, String> attributes) {
        return new Book(attributes.get("title"), attributes.get("author"), Float.parseFloat(attributes.get("price")), 
        LocalDate.parse(attributes.get("publicationDate")), attributes.get("description"));
    }
}