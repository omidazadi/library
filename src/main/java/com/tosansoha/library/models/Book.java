package com.tosansoha.library.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "Book")
public class Book {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private Float price;
    @Column(name = "publicationDate", columnDefinition = "DATE")
    private LocalDate publicationDate;
    @Column(name = "_description")
    private String description;
    @OneToMany(mappedBy = "book")
    private Set<Ownership> ownerships;

    public Book() {
    }

    public Book(String title, String author, Float price, LocalDate publicationDate, String description) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationDate = publicationDate;
        this.description = description;
    }
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ownership> getOwnerships() {
        return this.ownerships;
    }

    public void setOwnerships(Set<Ownership> ownerships) {
        this.ownerships = ownerships;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
        .append("id", this.getId())
        .append("title", this.getTitle())
        .append("author", this.getAuthor())
        .append("price", this.getPrice())
        .append("publicationDate", this.getPublicationDate())
        .append("description", this.getDescription())
        .toString();
    }
}