package com.university.student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.university.student.Entity.Student;
import com.university.student.Repository.StudentRepository;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public  List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Integer studentId){
        return studentRepository.findById(studentId);
    }
}
