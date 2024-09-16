package com.university.teacher.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.teacher.Entity.Teacher;
import com.university.teacher.Service.TeacherService;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.addTeacher(teacher);
        Integer teacherId = savedTeacher.getId();

        return ResponseEntity.status(HttpStatus.CREATED)
        .body("The Teacher "+teacherId+" has been successfully created with the status code "+HttpStatus.CREATED);
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/school/{schoolId}")
    public List<Teacher> findSchoolWithTeacher(@PathVariable("schoolId") Integer schoolId){
            return teacherService.getAllTeacherBySchool(schoolId);
    }
}
