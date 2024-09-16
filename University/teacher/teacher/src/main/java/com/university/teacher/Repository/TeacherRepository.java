package com.university.teacher.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.teacher.Entity.Teacher;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findAllBySchoolId(Integer schoolId);
}
