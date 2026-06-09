package com.abinash.personnel.hospitalManagement.repository;

import com.abinash.personnel.hospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}

// create three appointment for a patient and then delete Patient