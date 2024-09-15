package com.university.student.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.student.Entity.Student;
import com.university.student.Service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> GetAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);

        Integer studentNumber = savedStudent.getId();
        return ResponseEntity.status(HttpStatus.OK)
        .body("Student "+ studentNumber +" is saved in the database successfully with the status "+HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Integer studentId ){
            return studentService.findStudentById(studentId);
    }

    @GetMapping("/school/{schoolId}")
    public List<Student> getAllStudentBySchool(@PathVariable("schoolId") Integer schoolId){
        return studentService.findAllStudentsBySchool(schoolId);
    }
}
