package com.abinash.personnel.hospitalManagement;

import com.abinash.personnel.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.abinash.personnel.hospitalManagement.entity.Patient;
import com.abinash.personnel.hospitalManagement.repository.PatientRepository;
import com.abinash.personnel.hospitalManagement.service.PatientService;
import com.abinash.personnel.hospitalManagement.type.BloodGroupType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;
    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }
    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);
//        List<Patient> patient = patientRepository.findByBornAfterDate(LocalDate.of(1993,3,14));
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0]+ " " + objects[1]);
//        }
//        int rowsUpdated = patientRepository.updateNameWithId("someone sdf",1L);
//        System.out.println(rowsUpdated);
//        List<BloodGroupCountResponseEntity> res = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponseEntity: res){
//            System.out.println(bloodGroupCountResponseEntity);
//        }
        Page<Patient> patients = patientRepository.findAllPatients(PageRequest.of(0,2, Sort.by("name")));
        for(Patient patient: patients){
            System.out.println(patient);
        }
    }
}
