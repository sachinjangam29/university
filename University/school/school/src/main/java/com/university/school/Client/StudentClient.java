package com.university.school.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.university.school.Entity.StudentDTO;

@FeignClient(name = "student", url="http://localhost:8090/api/v1/students")
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<StudentDTO> findAllStudentsBySchool(@PathVariable("school-id") Integer schoolId);
}
