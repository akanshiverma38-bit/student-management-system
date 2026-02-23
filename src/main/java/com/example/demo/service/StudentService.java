package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
    public Page<Student> getStudentsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }
}
