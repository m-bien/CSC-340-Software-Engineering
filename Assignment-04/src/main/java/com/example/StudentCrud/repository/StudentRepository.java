package com.example.StudentCrud.repository;
/**
 * REPOSITORY:
 * inferface of student
 */

import com.example.StudentCrud.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
