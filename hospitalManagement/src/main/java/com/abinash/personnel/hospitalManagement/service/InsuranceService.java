package com.abinash.personnel.hospitalManagement.service;

import com.abinash.personnel.hospitalManagement.entity.Insurance;
import com.abinash.personnel.hospitalManagement.entity.Patient;
import com.abinash.personnel.hospitalManagement.repository.InsuranceRepository;
import com.abinash.personnel.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private  final InsuranceRepository insuranceRepository;
    private  final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patient_id){
        Patient patient = patientRepository.findById(patient_id).orElseThrow(
                ()-> new EntityNotFoundException("Patient not found with patient id: "+patient_id)
        );
        patient.setInsurance(insurance);// important cascading concept // we have not defined proerp cascading things cascading means when something happening with parent entity what should happen to child entity
        // insurance may not be exist in the database it may be in the transient state, patient is in persistent state i want my persistent context should be this patient that's why i have to start one transactional session we have to start for that i have to add @Transactional
        // if we don't make insurance till yet patient.setInsurance first create insurance in the db then set it.
        insurance.setPatient(patient);// to maintain bidirectional consistancy not necessary can be ignored.
        return patient;
    }
    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("patient now found with id: "+patientId));
        patient.setInsurance(null); // Because as we used orphan removal true thats why when we dirty this it will remove
        // insurance from the patient
        return patient;
    }










}
