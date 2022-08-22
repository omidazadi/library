package com.tosansoha.library.models;

import java.time.LocalDate;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "Ownership")
public class Ownership {
    @EmbeddedId
    private OwnershipKey id;
    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "bookId")
    private Member member;
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "memberId")
    private Book book;
    @Column(name = "acquirementDate", columnDefinition = "DATE")
    private LocalDate acquirementDate;

    public Ownership() {
    }

    public Ownership(OwnershipKey id, Member member, Book book, LocalDate acquirementDate) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.acquirementDate = acquirementDate;
    }

    public OwnershipKey getId() {
        return this.id;
    }

    public void setId(OwnershipKey id) {
        this.id = id;
    }

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getAcquirementDate() {
        return this.acquirementDate;
    }

    public void setAcquirementDate(LocalDate acquirementDate) {
        this.acquirementDate = acquirementDate;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}