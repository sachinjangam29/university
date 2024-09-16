package com.university.school.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.university.school.Entity.TeacherDTO;

@FeignClient(name="teacher", url="http://localhost:8094/api/v1/teachers")
public interface  TeacherClient {
    @GetMapping("/school/{schoolId}")
    public List<TeacherDTO> findAllTeachersBySchool(@PathVariable("schoolId") Integer schoolId);
}
