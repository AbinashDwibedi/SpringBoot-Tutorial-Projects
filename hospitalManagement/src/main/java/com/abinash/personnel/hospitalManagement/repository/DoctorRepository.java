package com.abinash.personnel.hospitalManagement.repository;

import com.abinash.personnel.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}