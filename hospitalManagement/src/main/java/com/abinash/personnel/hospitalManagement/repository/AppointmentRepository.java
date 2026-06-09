package com.abinash.personnel.hospitalManagement.repository;

import com.abinash.personnel.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}