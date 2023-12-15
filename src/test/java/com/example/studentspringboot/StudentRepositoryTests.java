package com.example.studentspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindByLastNameIgnoreCase() {
        Student student = new Student("Никита", "Мисюркеев", "Вячеславович", "Б761-2");
        studentRepository.save(student);

        List<Student> retrievedStudents = studentRepository.findByLastNameIgnoreCase("Мисюркеев");

        assertEquals(1, retrievedStudents.size(), "Ожидается студент с указанной фамилией");
        assertEquals(student.getLastName(), retrievedStudents.get(0).getLastName());
    }
}