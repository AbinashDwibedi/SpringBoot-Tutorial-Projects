package com.abinash.personnel.hospitalManagement.repository;

import com.abinash.personnel.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.abinash.personnel.hospitalManagement.entity.Patient;
import com.abinash.personnel.hospitalManagement.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate date, String email); // jpquery
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT p from Patient p where p.bloodGroup= ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);
    @Query("SELECT p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);


    @Query("select new com.abinash.personnel.hospitalManagement.dto.BloodGroupCountResponseEntity( p.bloodGroup, Count(p)) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient_tble", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p Set p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppointment();
}
