package com.tosansoha.library;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tosansoha.library.models.Book;
import com.tosansoha.library.models.Member;
import com.tosansoha.library.models.Ownership;
import com.tosansoha.library.models.OwnershipKey;
import com.tosansoha.library.repositories.BookRepository;
import com.tosansoha.library.repositories.MemberRepository;
import com.tosansoha.library.repositories.OwnershipRepository;

@Service
public class TestService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private OwnershipRepository ownershipRepository;

    public TestService() {
    }

    public Book addBook() {
        Book newBook = new Book("Basic Economics", "Thomas Sowell", 
        0.99f, LocalDate.parse("2014-12-01"), "A citizen's guide to economics.");
        bookRepository.save(newBook);
        return newBook;
    }

    public Member addMember() {
        Member newMember = new Member("Gholi", LocalDate.parse("1957-03-10"), LocalDate.parse("2001-11-09"), null);
        memberRepository.save(newMember);
        return newMember;
    }

    public Ownership addOwnership(Book book, Member member) {
        Ownership newOwnership = new Ownership(new OwnershipKey(1, 1), member, book, LocalDate.parse("2001-11-09"));
        ownershipRepository.save(newOwnership);
        return newOwnership;
    }
}
