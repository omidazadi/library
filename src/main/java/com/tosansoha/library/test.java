package com.tosansoha.library;

import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.tosansoha.library.models.Book;
import com.tosansoha.library.repositories.BookRepository;

public class test implements CommandLineRunner {
    @Autowired
    private static BookRepository bookRepository;

    public void run(String... args) {
        //return;
        addBook();
    }

    private static void addBook() {
        Book newBook = new Book();
        newBook.setTitle("Basic Economics");
		newBook.setAuthor("Thomas Sowell");
		newBook.setPrice(10.99f);
		newBook.setPublicationDate(YearMonth.parse("2014-12"));
		newBook.setDescription("A citizen's guide to economics.");
        //System.out.println(newBook.getPublicationDate());
        //System.exit(0);
        bookRepository.save(newBook);
    }
}
