package com.university.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.school.Entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{

}
