package com.example.studentspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id).orElse(null);
    }

    @GetMapping("/find")
    public List<Student> findStudentByLastName(@RequestParam(name="lastname") String lastName) {
        return studentService.findStudentsByLastName(lastName);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(
            @PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}