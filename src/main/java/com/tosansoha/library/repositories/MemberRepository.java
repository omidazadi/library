package com.tosansoha.library.repositories;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tosansoha.library.models.*;

public interface MemberRepository extends JpaRepository <Member, Integer> {
    public static Member updateChanges(Member member, Map<String, String> changes) {
        if (changes.containsKey("name")){
            member.setName(changes.get("name"));
        }
        if (changes.containsKey("birthDate")){
            member.setBirthDate(LocalDate.parse(changes.get("birthDate")));
        }
        if (changes.containsKey("registrationDate")){
            member.setRegistrationDate(LocalDate.parse(changes.get("registrationDate")));
        }
        if (changes.containsKey("bio")){
            member.setBio(changes.get("bio"));
        }   
        return member;
    }

    public static Member mapToModel(Map<String, String> attributes) {
        return new Member(attributes.get("name"), LocalDate.parse(attributes.get("birthDate")), 
        LocalDate.parse(attributes.get("registrationDate")), attributes.getOrDefault("bio", null));
    }
}