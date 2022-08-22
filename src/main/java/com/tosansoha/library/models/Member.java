package com.tosansoha.library.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "Member")
public class Member {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "_name")
    private String name;
    @Column(name = "birthDate", columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(name = "registrationDate", columnDefinition = "DATE")
    private LocalDate registrationDate;
    @Column(name = "bio")
    private String bio;
    @OneToMany(mappedBy = "member")
    private Set<Ownership> ownerships;

    public Member() {
    }

    public Member(String name, LocalDate birthDate, LocalDate registrationDate, String bio) {
        this.name = name;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.bio = bio;
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

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}