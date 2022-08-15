package com.tosansoha.library.models;

import java.time.YearMonth;
import java.util.Set;

import javax.persistence.*;

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
    @Column(name = "publicationDate")
    private YearMonth publicationDate;
    @Column(name = "_description")
    private String description;
    @OneToMany(mappedBy = "book")
    private Set<Ownership> ownerships;

    public Book() {
    }

    public Book(Integer id, String title, String author, Float price, YearMonth publicationDate, String description, Set<Ownership> ownerships) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationDate = publicationDate;
        this.description = description;
        this.ownerships = ownerships;
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

    public YearMonth getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(YearMonth publicationDate) {
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

}