package com.abinash.restAPI.repository;

import com.abinash.restAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //optional to use
public interface StudentRepository extends JpaRepository<Student, Long> {

}
