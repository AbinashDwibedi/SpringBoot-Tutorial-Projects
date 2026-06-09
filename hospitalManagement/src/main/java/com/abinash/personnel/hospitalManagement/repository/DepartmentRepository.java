package com.abinash.personnel.hospitalManagement.repository;

import com.abinash.personnel.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}