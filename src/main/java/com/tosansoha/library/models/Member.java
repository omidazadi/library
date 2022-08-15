package com.tosansoha.library.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Member")
public class Member {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "_name")
    private String name;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @Column(name = "registrationDate")
    private LocalDate registrationDate;
    @Column(name = "bio")
    private String bio;
    @OneToMany(mappedBy = "member")
    private Set<Ownership> ownerships;

    public Member() {
    }

    public Member(Integer id, String name, LocalDate birthDate, LocalDate registrationDate, String bio, Set<Ownership> ownerships) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.bio = bio;
        this.ownerships = ownerships;
    }
     
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate.toString();
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

    public LocalDate getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Ownership> getOwnerships() {
        return this.ownerships;
    }

    public void setOwnerships(Set<Ownership> ownerships) {
        this.ownerships = ownerships;
    }

}