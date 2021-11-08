package com.prac.prac.repository;


import com.prac.prac.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {


}
