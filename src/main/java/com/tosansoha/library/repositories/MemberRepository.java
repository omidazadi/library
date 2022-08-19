package com.tosansoha.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tosansoha.library.models.*;

public interface MemberRepository extends JpaRepository <Member, Integer> {
}