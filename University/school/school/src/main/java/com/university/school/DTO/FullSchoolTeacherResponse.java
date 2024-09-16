package com.university.school.DTO;

import java.util.List;

import com.university.school.Entity.TeacherDTO;

import lombok.Builder;

@Builder
public class FullSchoolTeacherResponse {
    private String name;
    private String email;
    private List<TeacherDTO> teachers;
    
    public FullSchoolTeacherResponse() {
    }

    public FullSchoolTeacherResponse(String name, String email, List<TeacherDTO> teachers) {
        this.name = name;
        this.email = email;
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TeacherDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDTO> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "FullSchoolTeacherResponse [name=" + name + ", email=" + email + ", teachers=" + teachers + "]";
    }

}
