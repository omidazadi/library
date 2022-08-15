package com.tosansoha.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LibraryApplication{
    
	public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
	}

    /*
    private static void addMember() {
        EntityManager entityManager = factory.createEntityManager(); 
        entityManager.getTransaction().begin();
        Member newMember = new Member();
        newMember.setName("Gholi");
		newMember.setBirthDate("1957-03-10");
		newMember.setRegistrationDate("2001-11-09");
        entityManager.persist(newMember);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void addOwnership() {
        EntityManager entityManager = factory.createEntityManager(); 
        entityManager.getTransaction().begin();
        OwnershipKey key = new OwnershipKey();
        key.setBookId(1);
        key.setMemberId(1);
        Ownership newOwnership = new Ownership();
        newOwnership.setId(key);
		newOwnership.setAcquirementDate("2001-11-09");
        entityManager.persist(newOwnership);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    */
}