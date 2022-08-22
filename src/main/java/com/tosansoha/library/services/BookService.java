package com.tosansoha.library.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tosansoha.library.models.Book;
import com.tosansoha.library.repositories.BookRepository;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookService() {
    }

    public Book addBook(Map<String, String> attributes) {
        /* Book newBook = new Book("Basic Economics", "Thomas Sowell", 
        0.99f, LocalDate.parse("2014-12-01"), "A citizen's guide to economics."); */
        Book book = BookRepository.mapToModel(attributes);
        bookRepository.save(book);
        return book;
    }

    public Book updateBook(Integer id, Map<String, String> changes) {
        Book book = bookRepository.findById(id).get();
        book = BookRepository.updateChanges(book, changes);
        //System.out.println(changes.toString());
        bookRepository.save(book);
        return book;
    }

    public void deleteBook(Integer id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
    }

    public List<Book> getBookById(Integer id) {
        List<Book> result = new ArrayList<Book>();
        result.add(bookRepository.findById(id).get());
        return result;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
