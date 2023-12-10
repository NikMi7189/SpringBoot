package com.example.studentspringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String partonymicName;
    private String studentGroup;
    public Student() {
    }

    public Student(String firstName, String lastName, String partonymicName, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.partonymicName = partonymicName;
        this.studentGroup = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPartonymicName() {
        return partonymicName;
    }

    public void setPartonymicName(String partonymicName) {
        this.partonymicName = partonymicName;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(partonymicName, student.partonymicName) &&
                Objects.equals(studentGroup, student.studentGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, partonymicName, studentGroup);
    }
}
