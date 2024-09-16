package com.university.school.Controller;

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

import com.university.school.DTO.FullSchoolResponse;
import com.university.school.DTO.FullSchoolTeacherResponse;
import com.university.school.Entity.School;
import com.university.school.Service.SchoolService;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<String> addSchool(@RequestBody School school){
        School schoolDetail = schoolService.addSchool(school);

        Integer schoolNumber = schoolDetail.getId();

        return ResponseEntity.status(HttpStatus.OK)
        .body("School "+schoolNumber+" has been created successfully with the status "+HttpStatus.OK);
    }

    @GetMapping
    public List<School> getAllSchools(){
        return schoolService.getAllSchools();
    }

    @GetMapping("/{schoolId}")
    public Optional<School> getSchoolByid(@PathVariable("schoolId") Integer schoolId){
        return schoolService.findBySchooId(schoolId);        
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }

    @GetMapping("/with-teachers/{schoolId}")
    public ResponseEntity<FullSchoolTeacherResponse> findAllTeachersBySchoolId(@PathVariable("schoolId") Integer schoolId){
       return ResponseEntity.ok(schoolService.findSchoolWithTeacher(schoolId));
    }
}
