package com.example.studentspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByLastNameIgnoreCase (String lastname) ;
}