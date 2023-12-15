package com.example.studentspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentSpringBootApplicationTests {

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void testGetAllStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Никита", "Мисюркеев", "Вячеславович", "Б761-2"));
		students.add(new Student("Алексей", "Хохряков", "Петрович", "М573"));

		when(studentRepository.findAll()).thenReturn(students);

		List<Student> retrievedStudents = studentService.getAllStudents();
		assertEquals(2, retrievedStudents.size(), "Expected 2 students");
		System.out.println("Retrieved students: " + retrievedStudents);
	}

	@Test
	public void testGetStudentById() {
		Long id = 1L;
		Student student = new Student("Никита", "Мисюркеев", "Вячеславович", "Б761-2");
		student.setId(id);

		when(studentRepository.findById(id)).thenReturn(Optional.of(student));

		assertEquals(student, studentService.getStudentById(id).orElse(null));
	}

	@Test
	public void testAddStudent() {
		Student student = new Student("Никита", "Мисюркеев", "Вячеславович", "Б761-2");

		studentService.addStudent(student);

		verify(studentRepository, times(1)).save(student);
	}

	@Test
	public void testUpdateStudent() {
		Long id = 1L;
		Student student = new Student("Изменено", "Изменено", "Изменено", "Б761-2");
		student.setId(id);

		studentService.updateStudent(student);

		verify(studentRepository, times(1)).save(student);
	}

	@Test
	public void testDeleteStudent() {
		Long id = 1L;

		studentService.deleteStudent(id);

		verify(studentRepository, times(1)).deleteById(id);
	}

	@Test
	public void testFindStudentsByLastName() {
		String lastName = "Мисюркеев";
		List<Student> students = new ArrayList<>();
		students.add(new Student("Никита", "Мисюркеев", "Вячеславович", "Б761-2"));

		when(studentRepository.findByLastNameIgnoreCase(lastName)).thenReturn(students);

		assertEquals(1, studentService.findStudentsByLastName(lastName).size());
	}
}
