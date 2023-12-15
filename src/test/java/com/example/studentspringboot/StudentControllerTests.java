package com.example.studentspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudentById() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.get("/students/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindStudentByLastName() throws Exception {
        String lastName = "Мисюркеев";
        mockMvc.perform(MockMvcRequestBuilders.get("/students/find")
                        .param("lastname", lastName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/students")
                        .content("{ \"firstName\": \"Новый\", \"lastName\": \"Студент\", \"partonymicName\": \"Новый\", \"studentGroup\": \"Группа\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.put("/students/" + id)
                        .content("{ \"firstName\": \"Обновленный\", \"lastName\": \"Студент\", \"partonymicName\": \"Обновленный\", \"studentGroup\": \"Группа\" }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/students/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}