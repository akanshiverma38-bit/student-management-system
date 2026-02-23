package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    @GetMapping("/paginated")
    public Page<Student> getStudentsPaginated(
            @RequestParam int page,
            @RequestParam int size) {
        return service.getStudentsWithPagination(page, size);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
}
