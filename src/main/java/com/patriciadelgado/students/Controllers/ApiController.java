package com.patriciadelgado.students.Controllers;

import java.util.List;

import com.patriciadelgado.students.Models.Contact;
import com.patriciadelgado.students.Models.Students;
import com.patriciadelgado.students.Services.ApiService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final ApiService apiService;
    
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/students")
    public List<Students> index() {
        return apiService.allStudent();
    }
    @PostMapping("/api/students/create")
    public Students create(@RequestParam(value = "firstName") String firstName,
    @RequestParam(value ="lastName") String lastName,
            @RequestParam(value = "age") Integer age) {
        Students students = new Students(firstName, lastName, age);
        return apiService.createStudent(students);
    }
    @PostMapping("/api/contacts/create")
    public Contact createContact(@RequestParam(value = "student") Long id,
    @RequestParam(value ="address") String address,
     @RequestParam(value = "city") String city,
            @RequestParam(value = "state") String state) {
        Students student = apiService.findStudent(id);
        Contact contact =  new Contact(address, city, state, student);
        return apiService.createContact(contact);
    }
}
