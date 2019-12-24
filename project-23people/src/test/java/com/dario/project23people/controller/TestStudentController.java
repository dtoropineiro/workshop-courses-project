package com.dario.project23people.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dario.project23people.model.Student;
import com.dario.project23people.service.StudentService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;
@RunWith(SpringJUnit4ClassRunner.class)
public class TestStudentController {

    private MockMvc mockMvc;

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController,studentService)
                .build();
    }
    @Test
    public void validateRut() throws Exception {
        String rut = "12-4";
        Student student = new Student();
        student.setRut(rut);
        Gson gson = new Gson();
        String json = gson.toJson(student);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/students")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());


    }
}
