package com.university.school.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.university.school.Client.StudentClient;
import com.university.school.Client.TeacherClient;
import com.university.school.DTO.FullSchoolResponse;
import com.university.school.DTO.FullSchoolTeacherResponse;
import com.university.school.Entity.School;
import com.university.school.Repository.SchoolRepository;

@Service
public class SchoolService {
    
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;
    private final TeacherClient teacherClient;

    public SchoolService(SchoolRepository schoolRepository,StudentClient studentClient, TeacherClient teacherClient){
        this.schoolRepository = schoolRepository;      
        this.studentClient = studentClient;
        this.teacherClient = teacherClient;
    }

    public School addSchool(School school){
        return schoolRepository.save(school);
    }

    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public Optional<School> findBySchooId(Integer schoolId){
        return schoolRepository.findById(schoolId);
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

    public FullSchoolTeacherResponse findSchoolWithTeacher(Integer schoolId){
        var school = schoolRepository.findById(schoolId)
                    .orElse(School.builder()
                    .name("Not_Found")
                    .email("Not_Found")
                    .build());
        var teachers = teacherClient.findAllTeachersBySchool(schoolId);       
        return FullSchoolTeacherResponse.builder()
                        .name(school.getName())
                        .email(school.getEmail())
                        .teachers(teachers)
                        .build();     
    }
}
