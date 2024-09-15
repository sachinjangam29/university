package com.university.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.student.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
