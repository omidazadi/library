package com.tosansoha.library.services;

import java.time.LocalDate;
import java.util.Map;

import javax.transaction.Transactional;

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
@Transactional
public class OwnershipService {
    @Autowired
    private OwnershipRepository ownershipRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    public OwnershipService() {
    }

    public Ownership acquire(Integer memberId, Integer bookId, Map<String, String> attributes){
        OwnershipKey key = new OwnershipKey(memberId, bookId);
        System.out.println(key);
        Member member = memberRepository.getReferenceById(memberId);
        Book book = bookRepository.getReferenceById(bookId);
        Ownership ownership = new Ownership(key, member, book, LocalDate.parse(attributes.get("acquirementDate")));
        ownershipRepository.save(ownership);
        return ownership;
    }
}
