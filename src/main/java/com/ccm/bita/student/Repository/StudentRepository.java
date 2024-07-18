package com.ccm.bita.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccm.bita.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
