package com.university.teacher.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.teacher.Entity.Teacher;
import com.university.teacher.Repository.TeacherRepository;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    } 

    public List<Teacher> getAllTeacherBySchool(Integer schoolId){
        return teacherRepository.findAllBySchoolId(schoolId);
    }

}
