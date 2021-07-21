package com.patriciadelgado.students.Services;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.students.Models.Contact;
import com.patriciadelgado.students.Models.Students;
import com.patriciadelgado.students.Repositories.ContactRepository;
import com.patriciadelgado.students.Repositories.StudentsRepository;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
    private final StudentsRepository studentsRepository;
    private final ContactRepository contactRepository;


    public ApiService(StudentsRepository studentsRepository, ContactRepository contactRepository) {
        this.studentsRepository = studentsRepository;
        this.contactRepository = contactRepository;
    }


    public List<Students> allStudent() {
        return studentsRepository.findAll();
    }
    public Students createStudent(Students s) {
        return studentsRepository.save(s);
    }

    public Students findStudent(Long id) {
        Optional<Students> optionalStudent = studentsRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }

    public List<Contact> allContact() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findContact(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            return optionalContact.get();
        } else {
            return null;
        }
    }
 
}
