package com.abinash.personnel.hospitalManagement.service;

import com.abinash.personnel.hospitalManagement.entity.Patient;
import com.abinash.personnel.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    @Transactional // if we have multiple database things we can use transaction so that
    // everything goes to transaction if something went wrong then everything will be rollback
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1==p2) ; // it will return true as both transaciton are same;
        p1.setName("YOyo");
        return p1;
    }
}
